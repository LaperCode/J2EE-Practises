package com.example.votingsystem.service;

import com.example.votingsystem.dto.VoteResponse;
import com.example.votingsystem.entity.AppUser;
import com.example.votingsystem.entity.Restaurant;
import com.example.votingsystem.entity.Vote;
import com.example.votingsystem.exception.BusinessException;
import com.example.votingsystem.exception.ResourceNotFoundException;
import com.example.votingsystem.exception.VoteChangeNotAllowedException;
import com.example.votingsystem.repository.AppUserRepository;
import com.example.votingsystem.repository.RestaurantRepository;
import com.example.votingsystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.List;

@Service
public class VoteService {
    private final AppUserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;
    private final DishService dishService;
    private final Clock clock;
    private final LocalTime cutoffTime;

    public VoteService(AppUserRepository userRepository,
                       RestaurantRepository restaurantRepository,
                       VoteRepository voteRepository,
                       DishService dishService,
                       Clock clock,
                       @Value("${app.voting.cutoff-time:11:00}") LocalTime cutoffTime) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.voteRepository = voteRepository;
        this.dishService = dishService;
        this.clock = clock;
        this.cutoffTime = cutoffTime;
    }

    @Transactional
    public VoteResponse vote(UserDetails principal, Long restaurantId) {
        AppUser user = currentUser(principal);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found: " + restaurantId));

        LocalDate today = LocalDate.now(clock);
        LocalTime now = LocalTime.now(clock);

        if (!dishService.restaurantHasMenu(restaurantId, today)) {
            throw new BusinessException("This restaurant does not have a menu for today.");
        }

        Vote vote = voteRepository.findByUserIdAndVoteDate(user.getId(), today).orElse(null);
        if (vote == null) {
            return toResponse(voteRepository.save(new Vote(today, user, restaurant)));
        }

        if (!now.isBefore(cutoffTime)) {
            throw new VoteChangeNotAllowedException("Vote cannot be changed after " + cutoffTime + ".");
        }

        vote.setRestaurant(restaurant);
        return toResponse(voteRepository.save(vote));
    }

    @Transactional(readOnly = true)
    public VoteResponse getMyVote(UserDetails principal, LocalDate date) {
        AppUser user = currentUser(principal);
        return voteRepository.findByUserIdAndVoteDate(user.getId(), date)
            .map(this::toResponse)
            .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<VoteResponse> getHistory(UserDetails principal) {
        AppUser user = currentUser(principal);
        return voteRepository.findAllByUserIdOrderByVoteDateDesc(user.getId())
            .stream().map(this::toResponse).toList();
    }

    private AppUser currentUser(UserDetails principal) {
        String email = principal.getUsername();
        return userRepository.findByEmailIgnoreCase(email)
            .orElseThrow(() -> new ResourceNotFoundException("Authenticated user not found: " + email));
    }

    private VoteResponse toResponse(Vote vote) {
        return new VoteResponse(
            vote.getId(), vote.getVoteDate(),
            vote.getRestaurant().getId(), vote.getRestaurant().getTitle());
    }
}
