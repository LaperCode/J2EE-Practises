package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// [Câu a] Khởi tạo dự án Spring Boot làm nền tảng để dựng RESTful API.
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("=============================================");
        System.out.println("API đã chạy thành công tại cổng 8080!");
        System.out.println("=============================================");
    }
}
