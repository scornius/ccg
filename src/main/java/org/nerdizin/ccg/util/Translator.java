package org.nerdizin.ccg.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {

    public static String translate(final String key, final Locale locale) {
        final ResourceBundle bundle = ResourceBundle.getBundle("bundles/MainBundle", locale);
        return bundle.getString(key);
    }
}
