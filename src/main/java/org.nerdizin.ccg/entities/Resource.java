package org.nerdizin.ccg.entities;

public enum Resource {

    GOLD("G"),
    LIGHT_MANA("L"),
    DARK_MANA("D"),
    FIRE("F"),
    WATER("W"),
    AIR("A"),
    EARTH("E");

    private String code;

    Resource(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Resource getResourceByCode(final String code) {
        for (final Resource resource : values()) {
            if (resource.getCode().equalsIgnoreCase(code)) {
                return resource;
            }
        }
        throw new IllegalArgumentException("Unknown resource code: " + code);
    }
}
