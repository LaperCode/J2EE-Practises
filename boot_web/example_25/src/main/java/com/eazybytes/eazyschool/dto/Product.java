package com.eazybytes.eazyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String name;
    private double price;
    private boolean inStock;

    public boolean getInStock() {
        return this.inStock;
    }
}
