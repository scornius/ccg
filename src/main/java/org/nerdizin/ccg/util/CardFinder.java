package org.nerdizin.ccg.util;

import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.filter.CardFilter;
import org.nerdizin.ccg.filter.FilteringCollectingCardVisitor;

import java.util.List;

public class CardFinder {

    public static List<Card> findCards(final List<Card> cards, final CardFilter... filters) {

        final FilteringCollectingCardVisitor visitor = new FilteringCollectingCardVisitor(filters);
        cards.forEach(visitor::visit);
        return visitor.getCards();
    }

}
