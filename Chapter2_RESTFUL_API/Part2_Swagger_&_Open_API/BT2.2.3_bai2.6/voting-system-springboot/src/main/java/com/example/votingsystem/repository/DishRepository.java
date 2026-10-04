package com.example.votingsystem.repository;

import com.example.votingsystem.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByDateOrderByRestaurantIdAscIdAsc(LocalDate date);
    List<Dish> findAllByRestaurantIdAndDateOrderByIdAsc(Long restaurantId, LocalDate date);
    List<Dish> findAllByRestaurantIdOrderByDateDescIdAsc(Long restaurantId);
    boolean existsByRestaurantIdAndDate(Long restaurantId, LocalDate date);
    void deleteAllByRestaurantId(Long restaurantId);
}
