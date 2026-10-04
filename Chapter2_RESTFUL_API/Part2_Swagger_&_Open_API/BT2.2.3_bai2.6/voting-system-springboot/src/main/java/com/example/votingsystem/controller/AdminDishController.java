package com.example.votingsystem.controller;

import com.example.votingsystem.dto.DishRequest;
import com.example.votingsystem.dto.DishResponse;
import com.example.votingsystem.service.DishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admin/dishes")
@Tag(name = "Admin - Dishes")
@SecurityRequirement(name = "basicAuth")
public class AdminDishController {
    private final DishService service;

    public AdminDishController(DishService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all dishes")
    public List<DishResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get dish by id")
    public DishResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a dish for a restaurant")
    public ResponseEntity<DishResponse> create(@Valid @RequestBody DishRequest request) {
        DishResponse created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a dish")
    public DishResponse update(@PathVariable Long id, @Valid @RequestBody DishRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a dish")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
