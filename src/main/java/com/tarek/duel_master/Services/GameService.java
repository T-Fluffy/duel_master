package com.tarek.duel_master.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tarek.duel_master.Models.GameState;
import com.tarek.duel_master.Models.Player;
import com.tarek.duel_master.Repositories.GameRepository;
import com.tarek.duel_master.Repositories.PlayerRepository;

@Service
public class GameService {

     @Autowired
    private GameRepository gameRepository;
    
    @Autowired
    private PlayerRepository playerRepository;

    public GameState createGame(String player1Id, String player2Id) {
        Player player1 = playerRepository.findById(player1Id)
            .orElseThrow(() -> new RuntimeException("Player 1 not found"));
        
        Player player2 = playerRepository.findById(player2Id)
            .orElseThrow(() -> new RuntimeException("Player 2 not found"));

        GameState game = new GameState();
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setPlayer1Shields(5);
        game.setPlayer2Shields(5);
        game.setCurrentTurn("player1");
        
        return gameRepository.save(game);  // Persists to DB
    }

    public GameState getGame(String gameId) {
        return gameRepository.findById(gameId)
            .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public void updateGame(GameState game) {
        gameRepository.save(game);  // Updates existing record
    }
}
