package com.example.votingsystem.controller;

import com.example.votingsystem.dto.VoteResponse;
import com.example.votingsystem.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vote")
@Tag(name = "Voting")
@SecurityRequirement(name = "basicAuth")
public class VoteController {
    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @PostMapping("/{restaurantId}")
    @Operation(
        summary = "Create or change today's vote",
        description = "One vote per user per day. A vote may be changed before 11:00 local time; after 11:00 it is locked.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Vote created or changed"),
            @ApiResponse(responseCode = "400", description = "Restaurant has no menu today"),
            @ApiResponse(responseCode = "403", description = "Vote is locked after 11:00")
        }
    )
    public VoteResponse vote(@PathVariable Long restaurantId,
                             @AuthenticationPrincipal UserDetails principal) {
        return service.vote(principal, restaurantId);
    }

    @GetMapping
    @Operation(summary = "Get my vote for a date")
    public ResponseEntity<VoteResponse> getMyVote(
        @Parameter(description = "Date to query")
        @RequestParam LocalDate date,
        @AuthenticationPrincipal UserDetails principal) {
        VoteResponse response = service.getMyVote(principal, date);
        return response == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    @Operation(summary = "Get my voting history")
    public List<VoteResponse> getHistory(@AuthenticationPrincipal UserDetails principal) {
        return service.getHistory(principal);
    }
}
