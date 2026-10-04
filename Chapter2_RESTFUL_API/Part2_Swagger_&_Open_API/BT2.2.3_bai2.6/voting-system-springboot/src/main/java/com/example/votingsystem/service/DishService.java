package com.example.votingsystem.service;

import com.example.votingsystem.dto.DishRequest;
import com.example.votingsystem.dto.DishResponse;
import com.example.votingsystem.entity.Dish;
import com.example.votingsystem.entity.Restaurant;
import com.example.votingsystem.exception.ResourceNotFoundException;
import com.example.votingsystem.repository.DishRepository;
import com.example.votingsystem.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional(readOnly = true)
    public List<DishResponse> getAll() {
        return dishRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public DishResponse getById(Long id) {
        return toResponse(findEntity(id));
    }

    @Transactional
    public DishResponse create(DishRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.restaurantId())
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found: " + request.restaurantId()));
        return toResponse(dishRepository.save(new Dish(
            request.date(), request.name().trim(), request.price(), restaurant)));
    }

    @Transactional
    public DishResponse update(Long id, DishRequest request) {
        Dish dish = findEntity(id);
        Restaurant restaurant = restaurantRepository.findById(request.restaurantId())
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found: " + request.restaurantId()));
        dish.setDate(request.date());
        dish.setName(request.name().trim());
        dish.setPrice(request.price());
        dish.setRestaurant(restaurant);
        return toResponse(dishRepository.save(dish));
    }

    @Transactional
    public void delete(Long id) {
        dishRepository.delete(findEntity(id));
    }

    @Transactional(readOnly = true)
    public boolean restaurantHasMenu(Long restaurantId, LocalDate date) {
        return dishRepository.existsByRestaurantIdAndDate(restaurantId, date);
    }

    private Dish findEntity(Long id) {
        return dishRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Dish not found: " + id));
    }

    private DishResponse toResponse(Dish dish) {
        Restaurant restaurant = dish.getRestaurant();
        return new DishResponse(
            dish.getId(), dish.getDate(), dish.getName(), dish.getPrice(),
            restaurant.getId(), restaurant.getTitle());
    }
}
