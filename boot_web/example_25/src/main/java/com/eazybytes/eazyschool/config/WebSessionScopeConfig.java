package com.eazybytes.eazyschool.config;

import com.eazybytes.eazyschool.dto.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebSessionScopeConfig {

    @Bean
    @SessionScope
    public List<Product> shoppingCart(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Product("Iphone", 1000, true));
        list.add(new Product("Tablet", 2000, true));
        return list;
    }
}
