package com.example.votingsystem.repository;

import com.example.votingsystem.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByUserIdAndVoteDate(Long userId, LocalDate voteDate);
    List<Vote> findAllByUserIdOrderByVoteDateDesc(Long userId);
    void deleteAllByRestaurantId(Long restaurantId);
}
