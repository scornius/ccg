package org.nerdizin.ccg.entities;

import java.util.HashMap;
import java.util.Map;

public class CardSet {

    private String name;
    private Map<String, CardDefinition> definitions = new HashMap<>();

    public void addCardDefinition(final CardDefinition cardDefinition) {
        definitions.put(cardDefinition.getId(), cardDefinition);
    }

    public CardDefinition getCardDefinition(final String id) {
        return definitions.get(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CardSet{" +
                "name='" + name + '\'' +
                ", definitions=" + definitions +
                '}';
    }
}
