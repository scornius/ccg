package org.nerdizin.ccg.xml;

import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.entities.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class DeckParserTest {

    private static final Logger LOG = LoggerFactory.getLogger(DeckParserTest.class.getName());

    @Test
    void testParser() {

        final Deck deck = DeckParser.parseDeck(getResourceURL("deck1.xml"));
        LOG.info(deck.toString());
    }

    private URL getResourceURL(final String fileName) {
        return DeckParserTest.class.getClassLoader().getResource("decks/" + fileName);
    }

}
