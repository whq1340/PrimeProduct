package com.example.helloword.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//跨域问题配置
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  //允许跨域的路径
                //.allowedOrigins("*") //允许跨域访问的源（如：8080）
                //当allowCredentials为真时，allowedorigin不能包含特殊值"*",因此改为allowedOriginPatterns
                .allowedOriginPatterns("*")
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE") //允许请求的方法
                .maxAge(168000) //预检间隔时间
                .allowedHeaders("*") //允许发送的头部设置
                .allowCredentials(true); //是否允许发送cookie
    }
}
