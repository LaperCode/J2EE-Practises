package com.apress.springboot3recipes.library;

import com.apress.springboot3recipes.library.bean.Book;
import com.apress.springboot3recipes.library.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;

@SpringBootApplication
public class LibraryApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Bean
    public ApplicationRunner booksInitializer(BookService bookService) {
        return args -> {
            try {
                // Đọc file book.csv từ thư mục resources
                var booksFile = new org.springframework.core.io.ClassPathResource("book.csv").getInputStream();
                try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(booksFile))) {
                    br.lines()
                            .skip(1) // Bỏ qua dòng tiêu đề (isbn,title,authors)
                            .forEach(line -> {
                                // Thuật toán tách cột bằng dấu phẩy (bỏ qua dấu phẩy trong ngoặc kép)
                                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                                if (data.length >= 3) {
                                    String isbn = data[0].replace("\"", "").trim();
                                    String title = data[1].replace("\"", "").trim();
                                    String authors = data[2].replace("\"", "").trim();

                                    // Lưu sách vào bộ nhớ
                                    bookService.create(new Book(isbn, title, List.of(authors.split(", "))));
                                }
                            });
                }
            } catch (Exception e) {
                System.out.println("Lỗi đọc file CSV: " + e.getMessage());
            }
        };
    }
}
