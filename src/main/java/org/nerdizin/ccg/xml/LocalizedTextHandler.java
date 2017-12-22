package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.LocalizedText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class LocalizedTextHandler extends DefaultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LocalizedTextHandler.class.getName());

    private static final String LOCALIZED_TEXT = "LocalizedText";
    private static final String DESCRIPTION = "Description";

    private final LocalizedText localizedText;
    private final XMLReader parser;
    private final ContentHandler parent;
    private String language;
    private final StringBuffer content = new StringBuffer();


    LocalizedTextHandler(final XMLReader parser, final ContentHandler parent, final LocalizedText localizedText) {
        this.parser = parser;
        this.parent = parent;
        this.localizedText = localizedText;
    }

    public void handle() {
        parser.setContentHandler(this);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch(localName) {
            case LOCALIZED_TEXT:
                content.setLength(0);
                language = attributes.getValue("language");
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case LOCALIZED_TEXT:
                localizedText.addLocalizedText(language, content.toString());
                break;
            case DESCRIPTION:
                parser.setContentHandler(parent);
                break;
        }
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) throws SAXException {
        content.append(buffer, start, length);
    }
}
