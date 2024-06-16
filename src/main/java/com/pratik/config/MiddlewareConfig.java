package com.pratik.config;

import com.pratik.middleware.AgeValidationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {
    @Autowired
    private AgeValidationInterceptor ageValidationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ageValidationInterceptor).addPathPatterns("/api/users/**");
    }
}
