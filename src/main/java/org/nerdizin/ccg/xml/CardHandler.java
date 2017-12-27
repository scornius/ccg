package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class CardHandler extends BaseHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardHandler.class.getName());

    private static final String CARD = "Card";

    private final Deck deck;
    private final XMLReader parser;
    private final ContentHandler parent;

    CardHandler(final XMLReader parser, final ContentHandler parent, final Deck deck) {
        this.deck = deck;
        this.parser = parser;
        this.parent = parent;
    }

    public void handle() {
        parser.setContentHandler(this);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch(localName) {
            case CARD:
                final String id = attributes.getValue("id");
                final String numberStr = attributes.getValue("number");
                final int number = Integer.parseInt(numberStr);
                final Card card = new Card();
                LOG.info("id=" + id + ", number=" + number);
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case CARD:
                break;
            default:
                parser.setContentHandler(parent);
                break;
        }
    }
}
