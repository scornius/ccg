package org.nerdizin.ccg.entities;

import java.util.HashMap;
import java.util.Map;

public class LocalizedText {

    private Map<String, String> texts = new HashMap<>();

    public Map<String, String> getTexts() {
        return texts;
    }

    public void addLocalizedText(final String language, final String text) {
        texts.put(language, text);
    }

    @Override
    public String toString() {
        return "LocalizedText{" +
                "texts=" + texts +
                '}';
    }
}
