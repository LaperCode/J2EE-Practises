package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // CHỈ CHẠY 1 LẦN DUY NHẤT và lưu vào biến ctx
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        System.out.println("Welcome to Spring Boot!");

        // In ra tổng số lượng Beans
        System.out.println("# Beans: " + ctx.getBeanDefinitionCount());

        // Lấy danh sách tên, sắp xếp và in ra từng Bean
        String[] names = ctx.getBeanDefinitionNames();
        Arrays.sort(names);
        Arrays.asList(names).forEach(System.out::println);
    }
}
