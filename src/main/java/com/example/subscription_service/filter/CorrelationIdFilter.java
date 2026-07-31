package com.example.subscription_service.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http =
                (HttpServletRequest) request;

        String correlationId =
                http.getHeader("X-Correlation-ID");

        if(correlationId==null){

            correlationId= UUID.randomUUID().toString();
        }

        MDC.put("CorrelationId",correlationId);

        chain.doFilter(request,response);

        MDC.clear();

    }

}