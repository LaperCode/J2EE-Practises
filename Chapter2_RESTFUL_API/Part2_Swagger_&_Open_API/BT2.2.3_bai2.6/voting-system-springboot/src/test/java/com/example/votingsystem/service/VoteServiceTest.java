package com.example.votingsystem.service;

import com.example.votingsystem.entity.AppUser;
import com.example.votingsystem.entity.Restaurant;
import com.example.votingsystem.entity.Vote;
import com.example.votingsystem.repository.AppUserRepository;
import com.example.votingsystem.repository.RestaurantRepository;
import com.example.votingsystem.repository.VoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import java.time.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {
    @Mock AppUserRepository userRepository;
    @Mock RestaurantRepository restaurantRepository;
    @Mock VoteRepository voteRepository;
    @Mock DishService dishService;

    @Test
    void firstVoteIsCreated() {
        Clock clock = Clock.fixed(Instant.parse("2026-10-04T02:00:00Z"), ZoneOffset.UTC);
        VoteService service = new VoteService(userRepository, restaurantRepository, voteRepository, dishService, clock, LocalTime.of(11, 0));

        AppUser user = new AppUser("user@gmail.com", "pwd", "USER");
        user.setId(1L);
        Restaurant restaurant = new Restaurant("Local", "HCMC");
        restaurant.setId(10L);
        User principal = new User("user@gmail.com", "pwd", java.util.List.of());

        when(userRepository.findByEmailIgnoreCase("user@gmail.com")).thenReturn(Optional.of(user));
        when(restaurantRepository.findById(10L)).thenReturn(Optional.of(restaurant));
        when(dishService.restaurantHasMenu(10L, LocalDate.of(2026, 10, 4))).thenReturn(true);
        when(voteRepository.findByUserIdAndVoteDate(1L, LocalDate.of(2026, 10, 4))).thenReturn(Optional.empty());
        when(voteRepository.save(any(Vote.class))).thenAnswer(inv -> inv.getArgument(0));

        assertEquals(10L, service.vote(principal, 10L).restaurantId());
    }

    @Test
    void secondVoteBeforeCutoffChangesRestaurant() {
        Clock clock = Clock.fixed(Instant.parse("2026-10-04T02:30:00Z"), ZoneOffset.UTC);
        VoteService service = new VoteService(userRepository, restaurantRepository, voteRepository, dishService, clock, LocalTime.of(11, 0));

        AppUser user = new AppUser("user@gmail.com", "pwd", "USER");
        user.setId(1L);
        Restaurant oldRestaurant = new Restaurant("Local", "HCMC"); oldRestaurant.setId(10L);
        Restaurant newRestaurant = new Restaurant("Tiget", "HCMC"); newRestaurant.setId(20L);
        Vote vote = new Vote(LocalDate.of(2026, 10, 4), user, oldRestaurant);
        User principal = new User("user@gmail.com", "pwd", java.util.List.of());

        when(userRepository.findByEmailIgnoreCase("user@gmail.com")).thenReturn(Optional.of(user));
        when(restaurantRepository.findById(20L)).thenReturn(Optional.of(newRestaurant));
        when(dishService.restaurantHasMenu(20L, LocalDate.of(2026, 10, 4))).thenReturn(true);
        when(voteRepository.findByUserIdAndVoteDate(1L, LocalDate.of(2026, 10, 4))).thenReturn(Optional.of(vote));
        when(voteRepository.save(any(Vote.class))).thenAnswer(inv -> inv.getArgument(0));

        assertEquals(20L, service.vote(principal, 20L).restaurantId());
    }
}
