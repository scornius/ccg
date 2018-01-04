package org.nerdizin.ccg.entities;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocalizedText {

    private Map<String, String> texts = new HashMap<>();

    public Map<String, String> getTexts() {
        return texts;
    }

    public void addLocalizedText(final String language, final String text) {
        texts.put(language, text);
    }

    public String getLocalizedText(final Locale locale) {
        return getLocalizedText(locale.getLanguage());
    }

    public String getLocalizedText(final String language) {
        return texts.get(language);
    }

    @Override
    public String toString() {
        return "LocalizedText{" +
                "texts=" + texts +
                '}';
    }
}
