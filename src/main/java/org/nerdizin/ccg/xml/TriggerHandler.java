package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.Trigger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.util.Map;

public class TriggerHandler extends BaseHandler {

    private static final String TRIGGER = "Trigger";

    private final Map<String, Trigger> triggers;
    private final XMLReader parser;
    private final ContentHandler parent;
    private String name;


    TriggerHandler(final XMLReader parser, final ContentHandler parent, final Map<String, Trigger> triggers) {
        this.parser = parser;
        this.parent = parent;
        this.triggers = triggers;
    }

    public void handle() {
        parser.setContentHandler(this);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch(localName) {
            case TRIGGER:
                resetContent();
                name = attributes.getValue("name");
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case TRIGGER:
                triggers.put(name, new Trigger(name, getContent()));
                break;
            default:
                parser.setContentHandler(parent);
                break;
        }
    }
}
