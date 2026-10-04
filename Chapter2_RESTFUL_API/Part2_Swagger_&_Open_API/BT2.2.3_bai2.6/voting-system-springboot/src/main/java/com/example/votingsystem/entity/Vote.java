package com.example.votingsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
    name = "votes",
    uniqueConstraints = @UniqueConstraint(name = "uk_vote_user_date", columnNames = {"user_id", "vote_date"})
)
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vote_date", nullable = false)
    private LocalDate voteDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Vote() {}

    public Vote(LocalDate voteDate, AppUser user, Restaurant restaurant) {
        this.voteDate = voteDate;
        this.user = user;
        this.restaurant = restaurant;
    }

    public Long getId() { return id; }
    public LocalDate getVoteDate() { return voteDate; }
    public AppUser getUser() { return user; }
    public Restaurant getRestaurant() { return restaurant; }

    public void setId(Long id) { this.id = id; }
    public void setVoteDate(LocalDate voteDate) { this.voteDate = voteDate; }
    public void setUser(AppUser user) { this.user = user; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
