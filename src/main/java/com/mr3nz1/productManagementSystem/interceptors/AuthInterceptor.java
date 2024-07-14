package com.mr3nz1.productManagementSystem.interceptors;

import com.mr3nz1.productManagementSystem.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {


        if (request.getHeader("Authorization") == null || !Objects.equals(request.getHeader("Authorization").split(" ")[1], "123")) {

            Logger.log(request.getMethod() + ": " + request.getRequestURL() + " -- Access denied\n");

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().println("Unauthorized");


            return false;
        }

        Logger.log(request.getMethod() + ": " + request.getRequestURL() + " -- Request authorized\n");

        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {

    }
}
