package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.xml.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CardSetHandler extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetHandler.class.getName());

    public static final String NAME = "Name";

    private CardSet cardSet = new CardSet();
    private CardDefinitionHandler cardDefinitionHandler;
    private StringBuffer content = new StringBuffer();



    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) throws SAXException {

        switch(localName) {
            case NAME: content.setLength(0); break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        switch(localName) {
            case NAME : cardSet.setName(content.toString());
                LOG.info(cardSet.getName());
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
