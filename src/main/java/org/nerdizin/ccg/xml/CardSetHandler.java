package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.CardSet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class CardSetHandler extends BaseHandler {

    private static final String NAME = "Name";
    private static final String DEFINITIONS = "Definitions";

    private XMLReader parser;
    private CardSet cardSet = new CardSet();


    CardSetHandler(final XMLReader parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) throws SAXException {

        switch(localName) {
            case NAME:
                resetContent();
                break;
            case DEFINITIONS:
                new CardDefinitionHandler(parser, this, cardSet).handle();
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case NAME :
                cardSet.setName(getContent());
                break;
        }
    }

    public CardSet getCardSet() {
        return cardSet;
    }
}
