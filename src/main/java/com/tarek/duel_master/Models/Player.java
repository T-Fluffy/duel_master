package com.tarek.duel_master.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter(AccessLevel.NONE)  // Prevent Lombok from generating setters for id
@Table(name = "players")  // Explicit table name
public class Player {
    @Id
    private String id;  // UUID or username

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;  // Store encrypted only

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> deck;  // Cards owned by player

    // Example: Additional fields
    private int wins;
    private int losses;

    // Manual constructor (optional)
    public Player(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }
}