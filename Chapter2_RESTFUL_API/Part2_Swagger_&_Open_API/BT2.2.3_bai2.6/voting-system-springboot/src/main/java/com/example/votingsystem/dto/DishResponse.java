package com.example.votingsystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DishResponse(
    Long id,
    LocalDate date,
    String name,
    BigDecimal price,
    Long restaurantId,
    String restaurantTitle
) {}
