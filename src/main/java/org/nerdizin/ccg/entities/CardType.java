package org.nerdizin.ccg.entities;

import org.nerdizin.ccg.util.Translator;

import java.util.Locale;

public enum CardType {

    LOCATION("Location"),
    CREATURE("Creature");

    private final String name;

    CardType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocalizedName(final Locale locale) {
        return Translator.translate(name, locale);
    }

    public static CardType getCardTypeByName(final String name) {
        for (final CardType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown type name: " + name);
    }
}
