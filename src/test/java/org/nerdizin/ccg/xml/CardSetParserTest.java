package org.nerdizin.ccg.xml;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CardSetParserTest {

    @Test
    public void testParser() {


        CardSetParser.parseCardSet(getResourceURL("base.xml"));


    }

    private URL getResourceURL(final String fileName) {
        return CardSetParserTest.class.getClassLoader().getResource("cardsets/" + fileName);
    }
}