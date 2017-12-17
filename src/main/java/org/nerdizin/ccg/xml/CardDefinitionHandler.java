package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.xml.CardDefinition;
import org.nerdizin.ccg.entities.xml.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class CardDefinitionHandler extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardDefinitionHandler.class.getName());

    private static final String DEFINITIONS = "Definitions";
    private static final String DEFINITION = "Definition";
    private static final String NAME = "Name";
    private static final String ID = "Id";

    private final CardSet cardSet;
    private final XMLReader parser;
    private final ContentHandler parent;
    private CardDefinition cardDefinition;
    private final StringBuffer content = new StringBuffer();

    CardDefinitionHandler(final XMLReader parser, final ContentHandler parent, final CardSet cardSet) {
        this.parser = parser;
        this.parent = parent;
        this.cardSet = cardSet;
    }

    public void handle() {
        parser.setContentHandler(this);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch(localName) {
            case NAME:
            case ID:
                content.setLength(0);
                break;
            case DEFINITION:
                cardDefinition = new CardDefinition();
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case NAME :
                cardDefinition.setName(content.toString());
                break;
            case ID:
                cardDefinition.setId(Integer.parseInt(content.toString()));
                break;
            case DEFINITION :
                cardSet.addCardDefinition(cardDefinition);
                break;
            case DEFINITIONS :
                parser.setContentHandler(parent);
                break;
        }
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) throws SAXException {
        content.append(buffer, start, length);
    }

}
