package org.nerdizin.ccg.xml;

import org.nerdizin.ccg.entities.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CardSetParser {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetParser.class.getName());

    public static CardSet parseCardSet(final URL cardSetURL) {
        final SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        final CardSetHandler cardSetHandler;
        try (InputStream is = cardSetURL.openStream()) {
            final SAXParser saxParser = spf.newSAXParser();
            final XMLReader xmlReader = saxParser.getXMLReader();
            cardSetHandler = new CardSetHandler(xmlReader);
            xmlReader.setContentHandler(cardSetHandler);
            xmlReader.setErrorHandler(new LoggingErrorHandler());
            xmlReader.parse(new InputSource(is));
        } catch (Exception e) {
            LOG.error("ParserConfigurationException", e);
            return null;
        }
        return cardSetHandler.getCardSet();
    }

    public static void parseCardSet(final String fileName) throws MalformedURLException {
        parseCardSet(convertToFileURL(fileName));
    }

    private static URL convertToFileURL(final String fileName) throws MalformedURLException {
        String path = new File(fileName).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        return new URL("file:" + path);
    }
}
