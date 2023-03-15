package com.example.helloword.config;

import com.example.helloword.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器作用的目标目录
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/hello");
    }
}
