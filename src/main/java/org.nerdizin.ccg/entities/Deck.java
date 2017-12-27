package org.nerdizin.ccg.entities;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private String name;
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(final Card card) {
        this.cards.add(card);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
