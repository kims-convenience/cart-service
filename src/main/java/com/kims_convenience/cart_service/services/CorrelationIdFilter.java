package com.kims_convenience.cart_service.services;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
public class CorrelationIdFilter implements Filter {
    public static final String CORRELATION_ID = "X-Correlation-ID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String correlationId = Optional.ofNullable(httpRequest.getHeader(CORRELATION_ID))
                .orElse(UUID.randomUUID().toString());

        MDC.put(CORRELATION_ID, correlationId); // For logging context

        try {
            chain.doFilter(request, response); // Continue the filter chain
        } finally {
            MDC.remove(CORRELATION_ID); // Clean up thread-local after request
        }
    }
}
