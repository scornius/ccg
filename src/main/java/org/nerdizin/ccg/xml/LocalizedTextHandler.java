package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.LocalizedText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class LocalizedTextHandler extends BaseHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LocalizedTextHandler.class.getName());

    private static final String LOCALIZED_TEXT = "LocalizedText";

    private final LocalizedText localizedText;
    private final XMLReader parser;
    private final ContentHandler parent;
    private String language;


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
                resetContent();
                language = attributes.getValue("language");
                break;
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch(localName) {
            case LOCALIZED_TEXT:
                localizedText.addLocalizedText(language, getContent());
                break;
            default:
                parser.setContentHandler(parent);
                break;
        }
    }

}
