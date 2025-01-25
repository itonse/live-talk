package com.itonse.livetalk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String API_PATH_PATTERN = "/*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(API_PATH_PATTERN)    // 모든 경로 허용
                .allowedOriginPatterns("http://localhostL*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)    // 자격 증명 허용
                .maxAge(3600);   // preflight 요청 캐시 시간
    }
}
