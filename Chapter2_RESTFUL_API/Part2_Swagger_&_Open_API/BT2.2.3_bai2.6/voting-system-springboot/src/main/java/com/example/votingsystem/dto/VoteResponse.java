package com.example.votingsystem.dto;

import java.time.LocalDate;

public record VoteResponse(
    Long id,
    LocalDate date,
    Long restaurantId,
    String restaurantTitle
) {}
