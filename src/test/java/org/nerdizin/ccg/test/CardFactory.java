package org.nerdizin.ccg.test;

import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.CardDefinition;
import org.nerdizin.ccg.entities.CardSet;
import org.nerdizin.ccg.xml.CardSetParser;

import java.net.URL;

public class CardFactory {

    private CardSet cardSet;

    public CardFactory() {
        this("base.xml");
    }

    public CardFactory(final String fileName) {
        this.cardSet = loadCardSet(fileName);
    }

    public Card createCardById(final String id) {
        return new Card(getCardDefinitionById(id));
    }

    public CardDefinition getCardDefinitionById(final String id) {
        return cardSet.getCardDefinition(id);
    }

    private static CardSet loadCardSet(final String fileName) {
        return CardSetParser.parseCardSet(getResourceURL(fileName));
    }

    private static URL getResourceURL(final String fileName) {
        return CardFactory.class.getClassLoader().getResource("cardsets/" + fileName);
    }
}
