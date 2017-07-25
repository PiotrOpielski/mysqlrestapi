package com.mysqlapi.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Token");

        if (authorization != null)
        {
            AuthToken token = new AuthToken(authorization);
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }
}