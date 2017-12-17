package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.xml.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class CardSetHandler extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetHandler.class.getName());

    public static final String NAME = "Name";
    public static final String DEFINITION = "Definition";
    public static final String DEFINITIONS = "Definitions";

    private XMLReader parser;
    private CardSet cardSet = new CardSet();
    private CardDefinitionHandler cardDefinitionHandler;
    private StringBuffer content = new StringBuffer();


    public CardSetHandler(final XMLReader parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) throws SAXException {

        switch(localName) {
            case NAME:
                content.setLength(0);
                break;
            case DEFINITION:
                cardDefinitionHandler = new CardDefinitionHandler(parser, this);
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case NAME :
                cardSet.setName(content.toString());
                LOG.info("1 " + cardSet);
                break;
            case DEFINITIONS:
                cardSet.addCardDefinition(cardDefinitionHandler.getCardDefinition());
                LOG.info("2 " + cardSet);
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
