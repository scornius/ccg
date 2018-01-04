package org.nerdizin.ccg.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.test.CardFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

class CardPrinterTest {

    private static final Logger LOG = LoggerFactory.getLogger(CardPrinterTest.class.getName());

    private static CardFactory cardFactory;

    @BeforeAll
    static void init() {
        cardFactory = new CardFactory();
    }

    @Test
    void testPrintCard() {

        final Card card = cardFactory.createCardById("GOLD_MINE");
        LOG.info(CardPrinter.printCard(card, Locale.ENGLISH));
        LOG.info(CardPrinter.printCard(card, Locale.GERMAN));
    }
}