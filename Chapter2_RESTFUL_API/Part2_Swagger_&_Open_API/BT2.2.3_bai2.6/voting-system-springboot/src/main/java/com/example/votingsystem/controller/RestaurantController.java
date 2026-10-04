package com.example.votingsystem.controller;

import com.example.votingsystem.dto.RestaurantMenuResponse;
import com.example.votingsystem.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@Tag(name = "Restaurants")
@SecurityRequirement(name = "basicAuth")
public class RestaurantController {
    private final RestaurantService service;
    private final Clock clock;

    public RestaurantController(RestaurantService service, Clock clock) {
        this.service = service;
        this.clock = clock;
    }

    @GetMapping("/dishes")
    @Operation(summary = "Get restaurants and menus for a date")
    public List<RestaurantMenuResponse> getMenus(
        @Parameter(description = "Menu date. Defaults to today.")
        @RequestParam(required = false) LocalDate date) {
        return service.getMenus(date == null ? LocalDate.now(clock) : date);
    }

    @GetMapping("/searchByTitle")
    @Operation(summary = "Search restaurants by title")
    public List<RestaurantMenuResponse> searchByTitle(
        @Parameter(description = "Text contained in restaurant title")
        @RequestParam String title,
        @Parameter(description = "Menu date. Defaults to today.")
        @RequestParam(required = false) LocalDate date) {
        return service.searchMenus(title, date == null ? LocalDate.now(clock) : date);
    }
}
