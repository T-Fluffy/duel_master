package com.tarek.duel_master.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarek.duel_master.Models.Card;
import com.tarek.duel_master.Models.GameState;
import com.tarek.duel_master.Models.Player;
import com.tarek.duel_master.Repositories.CardRepository;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

     public GameState createGame(Player player1, Player player2) {
        GameState game = new GameState();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setCurrentTurn("player1"); // Player 1 starts
        return game;
    }

    public void playCard(GameState game, Player player, Card card) {
        if (player.equals(game.getPlayer1())) {
            game.getPlayer1Field().add(card);
        } else {
            game.getPlayer2Field().add(card);
        }
    }
    public void endTurn(GameState game) {
        if ("player1".equals(game.getCurrentTurn())) {
            game.setCurrentTurn("player2");
        } else {
            game.setCurrentTurn("player1");
        }
        game.setTurnCount(game.getTurnCount() + 1);
    }
    public void attack(GameState game, Card attacker, Card defender) {
        // Implement attack logic here
        // For example, reduce defender's power or remove it from the field
    }
    public void setPlayerMana(GameState game, Player player, int mana) {
        if (player.equals(game.getPlayer1())) {
            game.setPlayer1Mana(mana);
        } else {
            game.setPlayer2Mana(mana);
        }
    }
    public void setPlayerShields(GameState game, Player player, int shields) {
        if (player.equals(game.getPlayer1())) {
            game.setPlayer1Shields(shields);
        } else {
            game.setPlayer2Shields(shields);
        }
    }
    public void setPlayerShieldsList(GameState game, Player player, List<Card> shieldsList) {
        if (player.equals(game.getPlayer1())) {
            game.setPlayer1ShieldsList(shieldsList);
        } else {
            game.setPlayer2ShieldsList(shieldsList);
        }
    }
    public void setGameStatus(GameState game, String status) {
        game.setStatus(status);
    }
    public void setGameId(GameState game, String gameId) {
        game.setGameId(gameId);
    }
    public void setPlayerFields(GameState game, Player player, List<Card> field) {
        if (player.equals(game.getPlayer1())) {
            game.setPlayer1Field(field);
        } else {
            game.setPlayer2Field(field);
        }
    }
    
    // Get all cards
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Get cards by civilization
    public List<Card> getCardsByCivilization(String civilization) {
        return cardRepository.findByCivilization(civilization);
    }

    // Save a new card (for admin use)
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    // Add this method if it doesn't exist
    public Card getCard(String cardId) {
        // TODO: Implement logic to fetch a Card by its ID
        // For now, throw an exception or return null as a placeholder
        throw new UnsupportedOperationException("getCard(String cardId) not implemented yet.");
    }
}