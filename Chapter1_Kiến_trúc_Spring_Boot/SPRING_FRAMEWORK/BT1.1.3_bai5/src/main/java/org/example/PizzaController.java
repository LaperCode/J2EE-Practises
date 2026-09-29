package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

    private VegPizza vegPizza;

    // Tiêm phụ thuộc qua Constructor (Constructor Injection)
    @Autowired
    public PizzaController(VegPizza vegPizza) {
        this.vegPizza = vegPizza;
    }

    public String getPizza() {
        return vegPizza.getPizza();
    }
}