package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.CardSet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class CardSetHandler extends DefaultHandler {

    private static final String NAME = "Name";
    private static final String DEFINITIONS = "Definitions";

    private XMLReader parser;
    private CardSet cardSet = new CardSet();
    private StringBuffer content = new StringBuffer();


    CardSetHandler(final XMLReader parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) throws SAXException {

        switch(localName) {
            case NAME:
                content.setLength(0);
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
                cardSet.setName(content.toString());
                break;
        }
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) throws SAXException {
        content.append(buffer, start, length);
    }

    public CardSet getCardSet() {
        return cardSet;
    }
}
