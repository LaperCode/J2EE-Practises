package com.example.votingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RestaurantRequest(
    @NotBlank @Size(max = 150) String title,
    @NotBlank @Size(max = 255) String location
) {}
