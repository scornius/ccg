package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.Deck;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class DeckHandler extends BaseHandler {

    private static final String NAME = "Name";
    private static final String CARDS = "Cards";

    private XMLReader parser;
    private Deck deck = new Deck();

    public DeckHandler(final XMLReader parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) throws SAXException {

        switch(localName) {
            case NAME:
                resetContent();
                break;
            case CARDS:
                new CardHandler(parser, this, deck).handle();
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case NAME :
                deck.setName(getContent());
                break;
        }
    }

    public Deck getDeck() {
        return deck;
    }
}
