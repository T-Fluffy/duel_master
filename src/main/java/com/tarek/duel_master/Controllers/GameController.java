package com.tarek.duel_master.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.tarek.duel_master.Models.GameState;
import com.tarek.duel_master.Models.PlayCardRequest;
import com.tarek.duel_master.Models.Player;
import com.tarek.duel_master.Services.CardService;
import com.tarek.duel_master.Services.GameService;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private CardService cardService;
    /**
     * Endpoint to handle playing a card in the game.
     * This method will be called when a player plays a card.
     *
     * @param request The request containing game ID, player ID, and card ID.
     * @return The updated game state after playing the card.
     */
    
    // WebSocket endpoint
    @MessageMapping("/game/play-card")
    @SendTo("/topic/game-updates")
    public GameState playCard(@Payload PlayCardRequest request) {
        // 1. Fetch and validate
        GameState game = gameService.getGame(request.getGameId());

        Card card = cardService.getCard(request.getCardId()); // Assume this exists

        // 2. Process the move
        gameService.playCard(game, request.getPlayerId(), card);

        // 3. Broadcast updated state
        return game;
    }
}
