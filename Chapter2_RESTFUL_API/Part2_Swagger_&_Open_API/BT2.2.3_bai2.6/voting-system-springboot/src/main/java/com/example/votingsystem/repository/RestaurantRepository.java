package com.example.votingsystem.repository;

import com.example.votingsystem.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title);
}
