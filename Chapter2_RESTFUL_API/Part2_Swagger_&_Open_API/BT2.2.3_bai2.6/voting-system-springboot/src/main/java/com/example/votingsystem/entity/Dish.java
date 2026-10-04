package com.example.votingsystem.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Dish() {}

    public Dish(LocalDate date, String name, BigDecimal price, Restaurant restaurant) {
        this.date = date;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public Restaurant getRestaurant() { return restaurant; }

    public void setId(Long id) { this.id = id; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setName(String name) { this.name = name; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
