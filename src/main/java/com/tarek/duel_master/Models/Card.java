package com.tarek.duel_master.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter(AccessLevel.PROTECTED)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String civilization; // Fire, Water, Nature, etc.
    private int power;
    private String effect;
    private String image_url; // URL to the card image
}