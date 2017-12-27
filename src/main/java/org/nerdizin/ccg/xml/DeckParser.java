package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.net.URL;

public class DeckParser {

    private static final Logger LOG = LoggerFactory.getLogger(DeckParser.class.getName());

    public static Deck parseDeck(final URL cardSetURL) {
        final SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        final DeckHandler deckHandler;
        try (InputStream is = cardSetURL.openStream()) {
            final SAXParser saxParser = spf.newSAXParser();
            final XMLReader xmlReader = saxParser.getXMLReader();
            deckHandler = new DeckHandler(xmlReader);
            xmlReader.setContentHandler(deckHandler);
            xmlReader.setErrorHandler(new LoggingErrorHandler());
            xmlReader.parse(new InputSource(is));
        } catch (Exception e) {
            LOG.error("ParserConfigurationException", e);
            return null;
        }
        return deckHandler.getDeck();
    }
}
