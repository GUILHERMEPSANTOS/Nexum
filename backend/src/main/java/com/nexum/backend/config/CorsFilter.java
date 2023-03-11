package com.nexum.backend.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    private static final String ALLOWED_ORIGINS = "http://nexum.zapto.org";
    private static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE, OPTIONS";
    private static final String ALLOWED_HEADERS = "Content-Type";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", ALLOWED_ORIGINS);
        response.setHeader("Access-Control-Allow-Methods", ALLOWED_METHODS);
        response.setHeader("Access-Control-Allow-Headers", ALLOWED_HEADERS);
        response.setHeader("Access-Control-Max-Age", "3600");
        if (!request.getMethod().equals("OPTIONS")) {
            chain.doFilter(req, res);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
