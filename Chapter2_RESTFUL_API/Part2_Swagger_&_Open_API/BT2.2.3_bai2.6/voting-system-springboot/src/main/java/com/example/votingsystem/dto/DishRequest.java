package com.example.votingsystem.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DishRequest(
    @NotNull LocalDate date,
    @NotBlank @Size(max = 150) String name,
    @NotNull @DecimalMin(value = "0.0", inclusive = true) BigDecimal price,
    @NotNull @Positive Long restaurantId
) {}
