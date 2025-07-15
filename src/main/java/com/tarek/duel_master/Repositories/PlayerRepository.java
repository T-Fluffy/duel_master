package com.tarek.duel_master.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarek.duel_master.Models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    
    // Custom query: Find player by username (case-insensitive)
    Optional<Player> findByUsernameIgnoreCase(String username);

    // Custom query: Check if username exists
    boolean existsByUsername(String username);
}