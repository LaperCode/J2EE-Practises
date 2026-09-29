package org.example;

import org.springframework.stereotype.Component;

@Component
public class VegPizza {
    public String getPizza() {
        return "Bánh Veg Pizza đã sẵn sàng!";
    }
}