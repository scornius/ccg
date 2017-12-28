package org.nerdizin.ccg.filter;

import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.CardDefinition;
import org.nerdizin.ccg.entities.CardType;
import org.nerdizin.ccg.util.CardFinder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardFinderTest {

    @Test
    void testIdFilter() {

        final List<Card> cards = createCards();

        final List<Card> result = CardFinder.findCards(cards, new IdFilter("GOLD_MINE"));
        assertEquals(1, result.size());
        assertTrue(result.contains(cards.get(0)));
    }

    @Test
    void testTypeFilter() {

        final List<Card> cards = createCards();

        final List<Card> result = CardFinder.findCards(cards, new TypeFilter(CardType.LOCATION));
        assertEquals(2, result.size());
        assertTrue(result.contains(cards.get(0)));
        assertTrue(result.contains(cards.get(1)));
    }

    @Test
    void testCombinedFilters() {

        final List<Card> cards = createCards();

        List<Card> result = CardFinder.findCards(cards,
                new IdFilter("GOLD_MINE"),
                new TypeFilter(CardType.LOCATION));
        assertEquals(1, result.size());
        assertTrue(result.contains(cards.get(0)));

        result = CardFinder.findCards(cards,
                new IdFilter("GOLD_MINE"),
                new TypeFilter(CardType.CREATURE));
        assertEquals(0, result.size());
    }

    private List<Card> createCards() {

        final List<Card> result = new ArrayList<>();
        final CardDefinition cd1 = new CardDefinition();
        cd1.setId("GOLD_MINE");
        cd1.setType(CardType.LOCATION);
        final CardDefinition cd2 = new CardDefinition();
        cd2.setId("TEMPLE_OF_LIGHT");
        cd2.setType(CardType.LOCATION);
        final CardDefinition cd3 = new CardDefinition();
        cd3.setId("ORC");
        cd3.setType(CardType.CREATURE);
        final Card c1 = new Card(cd1);
        final Card c2 = new Card(cd2);
        final Card c3 = new Card(cd3);
        result.add(c1);
        result.add(c2);
        result.add(c3);

        return result;
    }
}