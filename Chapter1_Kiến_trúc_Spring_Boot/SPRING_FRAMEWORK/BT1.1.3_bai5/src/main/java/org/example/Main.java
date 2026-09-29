package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        PizzaController pizzaController = context.getBean(PizzaController.class);
        System.out.println(pizzaController.getPizza());

        context.close();
    }
}