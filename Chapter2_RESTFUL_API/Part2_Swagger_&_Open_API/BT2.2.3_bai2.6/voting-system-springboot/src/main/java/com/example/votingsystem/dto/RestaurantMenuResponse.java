package com.example.votingsystem.dto;

import java.util.List;

public record RestaurantMenuResponse(
    Long id,
    String title,
    String location,
    List<DishResponse> dishes
) {}
