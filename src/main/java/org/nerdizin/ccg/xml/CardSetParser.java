package org.nerdizin.ccg.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CardSetParser {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetParser.class.getName());

    public static void parseCardSet(final URL cardSetURL) {
        final SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        try (InputStream is = cardSetURL.openStream()) {
            final SAXParser saxParser = spf.newSAXParser();
            final XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new CardSetHandler());
            xmlReader.setErrorHandler(new LoggingErrorHandler());
            xmlReader.parse(new InputSource(is));
        } catch (ParserConfigurationException e) {
            LOG.error("ParserConfigurationException", e);
        } catch (SAXException e) {
            LOG.error("SAXException", e);
        } catch (IOException e) {
            LOG.error("IOException", e);
        }
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
