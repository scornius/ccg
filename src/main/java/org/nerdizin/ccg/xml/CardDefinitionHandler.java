package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.xml.CardDefinition;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class CardDefinitionHandler extends DefaultHandler {

    public static final String NAME = "Name";

    private XMLReader parser;
    private ContentHandler parent;
    private CardDefinition cardDefinition = new CardDefinition();
    private StringBuffer content = new StringBuffer();

    public CardDefinitionHandler(final XMLReader parser, final ContentHandler parent) {
        this.parser = parser;
        this.parent = parent;
        parser.setContentHandler(this);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch(localName) {
            case NAME: content.setLength(0); break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case NAME : cardDefinition.setName(content.toString());
                break;
            case "Definition" : parser.setContentHandler(parent);
                break;
        }
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) throws SAXException {
        content.append(buffer, start, length);
    }

    public CardDefinition getCardDefinition() {
        return cardDefinition;
    }
}
