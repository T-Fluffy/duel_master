package com.tarek.duel_master.Repositories;

import com.tarek.duel_master.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    
    // Custom query: Find cards by civilization (Fire, Water, etc.)
    List<Card> findByCivilization(String civilization);

    // Custom query: Find cards with power greater than a value
    List<Card> findByPowerGreaterThan(int power);

    // Custom query: Find cards by name (case-insensitive)
    List<Card> findByNameContainingIgnoreCase(String name);

    // Custom query: Find cards by effect (case-insensitive)
    List<Card> findByEffectContainingIgnoreCase(String effect);

    // Additional custom queries can be added as needed
    // Example: Find cards by multiple criteria
    List<Card> findByCivilizationAndPowerGreaterThan(String civilization, int power);

    // Example: Find cards by name and civilization
    List<Card> findByNameContainingIgnoreCaseAndCivilization(String name, String civilization);

    // Example: Find cards by effect and civilization
    List<Card> findByEffectContainingIgnoreCaseAndCivilization(String effect, String civilization);

    // Example: Find cards by power and civilization
    List<Card> findByPowerGreaterThanAndCivilization(int power, String civilization);

    // Example: Find cards by name and power
    List<Card> findByNameContainingIgnoreCaseAndPowerGreaterThan(String name, int power);

    // Example: Find cards by effect and power
    List<Card> findByEffectContainingIgnoreCaseAndPowerGreaterThan(String effect, int power);

    // Example: Find cards by name, effect, and civilization
    List<Card> findByNameContainingIgnoreCaseAndEffectContainingIgnoreCaseAndCivilization(String name, String effect, String civilization);

    // Example: Find cards by name, effect, and power
    List<Card> findByNameContainingIgnoreCaseAndEffectContainingIgnoreCaseAndPowerGreaterThan(String name, String effect, int power);

}