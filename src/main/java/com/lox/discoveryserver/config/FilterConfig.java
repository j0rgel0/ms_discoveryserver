package com.lox.discoveryserver.config;

import com.lox.discoveryserver.logging.LoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Configuration class for registering filters.
 */
@Configuration
public class FilterConfig {

    /**
     * Registers the LoggingFilter to capture HTTP request details.
     *
     * @return an instance of LoggingFilter
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE) // Ensures this filter is applied first
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }
}
