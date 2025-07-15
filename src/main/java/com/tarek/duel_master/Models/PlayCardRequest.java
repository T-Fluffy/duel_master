package com.tarek.duel_master.Models;

import lombok.Data;

@Data
public class PlayCardRequest {
    private String gameId;     // Match identifier
    private String playerId;   // "player1" or "player2"
    private String cardId;     // ID of the card played
    public Player getPlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayer'");
    }
    public Card getCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCard'");
    }
}
