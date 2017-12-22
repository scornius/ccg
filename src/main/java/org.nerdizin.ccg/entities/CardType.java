package org.nerdizin.ccg.entities;

public enum CardType {

    LOCATION("Location");

    private final String name;

    CardType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
