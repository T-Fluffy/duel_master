package com.tarek.duel_master.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarek.duel_master.Models.GameState;

@Repository
public interface GameRepository extends JpaRepository<GameState, String> {
    // Custom query example: Find active games by player ID
    List<GameState> findByPlayer1IdOrPlayer2Id(String player1Id, String player2Id);
}
