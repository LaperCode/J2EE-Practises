package com.eazybytes.eazyschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class EazyschoolApplication {
	public static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext
				= SpringApplication.run(EazyschoolApplication.class, args);
	}
}
