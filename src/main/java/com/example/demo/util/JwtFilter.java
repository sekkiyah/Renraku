package com.example.demo.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.repositries.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        

        if (request.getCookies() == null) {
            chain.doFilter(request, response);
            return;
        }
        // Get authorization header and validate
        Optional<Cookie> jwtOpt = Arrays.stream(request.getCookies())
              .filter(cookie -> "jwt".equals(cookie.getName()))
              .findAny();
        
        if (jwtOpt.isEmpty()) {
            chain.doFilter(request, response);
            return;
        }

        String token = jwtOpt.get().getValue();
        
        // Get user identity and set it on the spring security context
        UserDetails userDetails = employeeRepository
            .findByUsername(jwtUtil.getUsernameFromToken(token))
            .orElse(null);
        
        // Get jwt token and validate
        if (!jwtUtil.validateToken(token, userDetails)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken
            authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                    List.of() : userDetails.getAuthorities()
            );

        authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        chain.doFilter(request, response);
        
    }
}
