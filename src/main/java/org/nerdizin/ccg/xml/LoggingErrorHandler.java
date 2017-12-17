package org.nerdizin.ccg.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class LoggingErrorHandler implements ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CardSetParser.class.getName());

    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        LOG.warn("", exception);
    }

    @Override
    public void error(final SAXParseException exception) throws SAXException {
        LOG.error("", exception);
    }

    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        LOG.error("", exception);
    }
}
