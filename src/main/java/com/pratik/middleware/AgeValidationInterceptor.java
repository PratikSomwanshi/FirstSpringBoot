package com.pratik.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AgeValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod()) ) {
            String ageParam = request.getParameter("age");

            if (ageParam == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Age parameter is missing");
                return false;
            }

            try {
                int age = Integer.parseInt(ageParam);
                if (age <= 15) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Age must be greater than 15");
                    return false;
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age parameter");
                return false;
            }
        }

        return true; // Continue with the next interceptor or the controller
    }
}
