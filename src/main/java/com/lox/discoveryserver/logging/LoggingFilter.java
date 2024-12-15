package com.lox.discoveryserver.logging;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A filter that captures HTTP request details and adds them to the MDC.
 */
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            // Add HTTP request URI to MDC
            MDC.put("requestURI", request.getRequestURI());

            // Add HTTP method type to MDC
            MDC.put("method", request.getMethod());

            // Proceed with the next filter in the chain
            filterChain.doFilter(request, response);
        } finally {
            // Remove the added MDC entries to prevent memory leaks
            MDC.remove("requestURI");
            MDC.remove("method");
        }
    }
}
