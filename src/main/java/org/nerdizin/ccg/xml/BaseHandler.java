package org.nerdizin.ccg.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BaseHandler extends DefaultHandler {

    private final StringBuffer content = new StringBuffer();


    void resetContent() {
        content.setLength(0);
    }

    String getContent() {
        return content.toString().trim();
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) throws SAXException {
        content.append(buffer, start, length);
    }

}
