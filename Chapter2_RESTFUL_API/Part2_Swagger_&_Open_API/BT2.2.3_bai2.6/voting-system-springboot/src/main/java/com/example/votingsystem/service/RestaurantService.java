package com.example.votingsystem.service;

import com.example.votingsystem.dto.DishResponse;
import com.example.votingsystem.dto.RestaurantMenuResponse;
import com.example.votingsystem.dto.RestaurantRequest;
import com.example.votingsystem.entity.Restaurant;
import com.example.votingsystem.exception.ResourceNotFoundException;
import com.example.votingsystem.repository.DishRepository;
import com.example.votingsystem.repository.RestaurantRepository;
import com.example.votingsystem.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;
    private final VoteRepository voteRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             DishRepository dishRepository,
                             VoteRepository voteRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
        this.voteRepository = voteRepository;
    }

    @Transactional(readOnly = true)
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found: " + id));
    }

    @Transactional
    public Restaurant create(RestaurantRequest request) {
        return restaurantRepository.save(new Restaurant(request.title().trim(), request.location().trim()));
    }

    @Transactional
    public Restaurant update(Long id, RestaurantRequest request) {
        Restaurant restaurant = getById(id);
        restaurant.setTitle(request.title().trim());
        restaurant.setLocation(request.location().trim());
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void delete(Long id) {
        Restaurant restaurant = getById(id);
        voteRepository.deleteAllByRestaurantId(restaurant.getId());
        dishRepository.deleteAllByRestaurantId(restaurant.getId());
        restaurantRepository.delete(restaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantMenuResponse> getMenus(LocalDate date) {
        return restaurantRepository.findAll().stream()
            .map(r -> toMenuResponse(r, date))
            .filter(r -> !r.dishes().isEmpty())
            .toList();
    }

    @Transactional(readOnly = true)
    public List<RestaurantMenuResponse> searchMenus(String title, LocalDate date) {
        return restaurantRepository.findByTitleContainingIgnoreCaseOrderByTitleAsc(title == null ? "" : title.trim())
            .stream()
            .map(r -> toMenuResponse(r, date))
            .filter(r -> !r.dishes().isEmpty())
            .toList();
    }

    private RestaurantMenuResponse toMenuResponse(Restaurant restaurant, LocalDate date) {
        List<DishResponse> dishes = dishRepository
            .findAllByRestaurantIdAndDateOrderByIdAsc(restaurant.getId(), date)
            .stream()
            .map(d -> new DishResponse(
                d.getId(), d.getDate(), d.getName(), d.getPrice(),
                restaurant.getId(), restaurant.getTitle()))
            .toList();
        return new RestaurantMenuResponse(restaurant.getId(), restaurant.getTitle(), restaurant.getLocation(), dishes);
    }
}
