package com.example.votingsystem.config;

import com.example.votingsystem.entity.AppUser;
import com.example.votingsystem.entity.Dish;
import com.example.votingsystem.entity.Restaurant;
import com.example.votingsystem.repository.AppUserRepository;
import com.example.votingsystem.repository.DishRepository;
import com.example.votingsystem.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Clock;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(AppUserRepository userRepository,
                               RestaurantRepository restaurantRepository,
                               DishRepository dishRepository,
                               PasswordEncoder encoder,
                               Clock clock) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new AppUser("admin@gmail.com", encoder.encode("admin"), "ADMIN"));
                userRepository.save(new AppUser("user@gmail.com", encoder.encode("12345678"), "USER"));
                userRepository.save(new AppUser("herbert@gmail.com", encoder.encode("herbert"), "USER"));
            }

            if (restaurantRepository.count() == 0) {
                LocalDate today = LocalDate.now(clock);
                Restaurant local = restaurantRepository.save(new Restaurant("Local", "33 Dark Spurt, Ho Chi Minh City"));
                Restaurant tiget = restaurantRepository.save(new Restaurant("Tiget", "3A Lenina Street, Ho Chi Minh City"));
                Restaurant shekspire = restaurantRepository.save(new Restaurant("Shekspire", "17 Kosmonavtov Street, Ho Chi Minh City"));

                dishRepository.save(new Dish(today, "Rice with grilled chicken", new BigDecimal("45000"), local));
                dishRepository.save(new Dish(today, "Vegetable soup", new BigDecimal("25000"), local));
                dishRepository.save(new Dish(today, "Shrimp & vegetables", new BigDecimal("60000"), tiget));
                dishRepository.save(new Dish(today, "Mint tea", new BigDecimal("20000"), tiget));
                dishRepository.save(new Dish(today, "Beef noodles", new BigDecimal("55000"), shekspire));
                dishRepository.save(new Dish(today, "Fried egg", new BigDecimal("15000"), shekspire));
            }
        };
    }
}
