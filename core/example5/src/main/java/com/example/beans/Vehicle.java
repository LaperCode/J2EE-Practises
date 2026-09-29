package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Vehicle {

    private String name;
    private double price;

    public String getName() {
        return name;
    }
    public double getPrice() {return price;}
    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println(
            "Printing Hello from Component Vehicle Bean");
    }

    @Autowired
    public Vehicle(String name, double price){
        this.name = name;
        this.price = price;
    }

    //@PostConstruct
    public void setDefaultName(){
        this.name = "default";
    }
}
