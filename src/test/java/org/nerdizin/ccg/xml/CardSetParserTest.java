package org.nerdizin.ccg.xml;

import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.entities.xml.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

class CardSetParserTest {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetParserTest.class.getName());

    @Test
    public void testParser() {

        final CardSet cardSet = CardSetParser.parseCardSet(getResourceURL("base.xml"));
        LOG.info(cardSet.toString());
    }

    private URL getResourceURL(final String fileName) {
        return CardSetParserTest.class.getClassLoader().getResource("cardsets/" + fileName);
    }
}