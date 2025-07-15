package com.tarek.duel_master.Controllers;

import java.util.List;
// import javax.smartcardio.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.tarek.duel_master.Repositories.CardRepository;
import com.tarek.duel_master.Models.Card;

public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Additional endpoints can be added here for specific queries
    // For example, to find cards by civilization:
    @GetMapping("/cards/civilization/{civilization}")
    public List<Card> getCardsByCivilization(String civilization) {
        return cardRepository.findByCivilization(civilization);
    }   
    // Example for finding cards with power greater than a value
    @GetMapping("/cards/power/{power}")
    public List<Card> getCardsByPowerGreaterThan(int power) {
        return cardRepository.findByPowerGreaterThan(power);
    }

    // Example for finding cards by name
    @GetMapping("/cards/name/{name}")
    public List<Card> getCardsByName(String name) {
        return cardRepository.findByNameContainingIgnoreCase(name);
    }

    // Example for finding cards by effect
    @GetMapping("/cards/effect/{effect}")
    public List<Card> getCardsByEffect(String effect) {
        return cardRepository.findByEffectContainingIgnoreCase(effect);
    }

    // For example, to find cards by multiple criteria: 
    @GetMapping("/cards/multiple-criteria")
    public List<Card> getCardsByMultipleCriteria(String civilization, int power, String name, String effect) {
        return cardRepository.findByCivilizationAndPowerGreaterThan(civilization, power);
    }
}
