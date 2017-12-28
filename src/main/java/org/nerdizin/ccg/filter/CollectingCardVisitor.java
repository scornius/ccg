package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CollectingCardVisitor implements CardVisitor {

    private List<Card> cards = new ArrayList<>();

    @Override
    public abstract void visit(final Card card);

    void addCard(final Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
