package com.tarek.duel_master.Models;

import java.util.List;

import lombok.Data;

@Data
public class GameState {
   
    private String gameId; 

    // Players in the game
    private Player player1;
    private Player player2;

    // Current turn (1 for player1, 2 for player2)
    private List<Card> player1Field;
    private List<Card> player2Field;

    // Player's shields
    private int player1Shields, player2Shields= 5; // Default shields for each player
    private int player1Mana, player2Mana; // Mana for each player
    private List<Card> player1ShieldsList;
    private List<Card> player2ShieldsList;

    // Game status (e.g., ongoing, finished)
    private String status;
    
    // Turn management
    private String currentTurn; // "player1" or "player2"
    private int turnCount;

    // Getters and setters for the fields
    public Player getPlayer(String playerId) {
        if (player1 != null && player1.getId().equals(playerId)) {
            return player1;
        } else if (player2 != null && player2.getId().equals(playerId)) {
            return player2;
        }
        throw new IllegalArgumentException("Player not found in this game.");
    }
}
