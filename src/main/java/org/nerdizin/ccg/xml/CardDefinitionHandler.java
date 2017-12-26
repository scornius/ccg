package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.CardType;
import org.nerdizin.ccg.entities.xml.CardDefinition;
import org.nerdizin.ccg.entities.xml.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class CardDefinitionHandler extends BaseHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardDefinitionHandler.class.getName());

    private static final String DEFINITIONS = "Definitions";
    private static final String DEFINITION = "Definition";
    private static final String NAME = "Name";
    private static final String ID = "Id";
    private static final String TYPE = "Type";
    private static final String DESCRIPTION = "Description";

    private final CardSet cardSet;
    private final XMLReader parser;
    private final ContentHandler parent;
    private CardDefinition cardDefinition;

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
                new LocalizedTextHandler(parser, this, cardDefinition.getName()).handle();
                break;
            case ID:
            case TYPE:
                resetContent();
                break;
            case DEFINITION:
                cardDefinition = new CardDefinition();
                break;
            case DESCRIPTION:
                new LocalizedTextHandler(parser, this, cardDefinition.getDescription()).handle();
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case ID:
                cardDefinition.setId(Integer.parseInt(getContent()));
                break;
            case TYPE:
                cardDefinition.setType(CardType.getCardTypeByName(getContent()));
                break;
            case DEFINITION :
                cardSet.addCardDefinition(cardDefinition);
                break;
            case DEFINITIONS :
                parser.setContentHandler(parent);
                break;
        }
    }

}
