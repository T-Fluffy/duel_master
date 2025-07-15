package com.tarek.duel_master.Models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter
public class Game {
    @Id
    private String gameId;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    @ElementCollection
    private List<Card> player1Field; // Cards in play

    @ElementCollection
    private List<Card> player2Field;

    private int player1Shields;
    private int player2Shields;

    private String currentTurn; // "player1" or "player2"
}
