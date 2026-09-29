package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype") // Báo cho Spring biết: Hãy tạo đối tượng mới mỗi lần được gọi!
    public MessageService messageService() {
        return new MessageService();
    }
}