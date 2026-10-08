package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // Ghi ngắn gọn thế này, Spring sẽ tự động quét mọi file nằm chung thư mục org.example
public class AppConfig {
}