package com.example.demo_bai2_chap2;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoBai2Chap2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBai2Chap2Application.class, args);
	}

    @Bean
    public ApplicationRunner calculationRunner(Calculator calculator) {
        return args -> {
            calculator.calculate(137, 21, '+');
            calculator.calculate(137, 21, '*');
            calculator.calculate(137, 21, '-');
        };
    }

}
