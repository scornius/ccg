package org.nerdizin.ccg.filter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.CardType;
import org.nerdizin.ccg.test.CardFactory;
import org.nerdizin.ccg.util.CardFinder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardFinderTest {

    private static CardFactory cardFactory;

    @BeforeAll
    static void init() {
        cardFactory = new CardFactory();
    }

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
        result.add(cardFactory.createCardById("GOLD_MINE"));
        result.add(cardFactory.createCardById("TEMPLE_OF_LIGHT"));
        result.add(cardFactory.createCardById("ORC"));

        return result;
    }
}