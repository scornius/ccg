package org.nerdizin.ccg.entities.xml;

import java.util.Map;

public class CardSet {

    private String name;
    private Map<Integer, CardDefinition> definitions;


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
