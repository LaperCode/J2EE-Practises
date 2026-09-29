package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public GreetingService greetingService() {
        GreetingService service = new GreetingService();
        service.setMessage("Hello Lập! Chào mừng đến với Spring IoC Container cấu hình bằng Java!");
        return service;
    }
}