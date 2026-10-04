package com.example.votingsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class AppConfig {
    @Bean
    public Clock applicationClock(@Value("${app.voting.zone-id:Asia/Ho_Chi_Minh}") String zoneId) {
        return Clock.system(ZoneId.of(zoneId));
    }
}
