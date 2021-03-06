package org.nerdizin.ccg.entities;

import java.util.HashMap;
import java.util.Map;

public class CardDefinition {

    private String id;
    private LocalizedText name;
    private CardType type;
    private LocalizedText description;
    private Map<String, Trigger> triggers = new HashMap<>();

    public CardDefinition() {
        name = new LocalizedText();
        description = new LocalizedText();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public LocalizedText getName() {
        return name;
    }

    public void setName(final LocalizedText name) {
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public void setType(final CardType type) {
        this.type = type;
    }

    public LocalizedText getDescription() {
        return description;
    }

    public void setDescription(final LocalizedText description) {
        this.description = description;
    }

    public Map<String, Trigger> getTriggers() {
        return triggers;
    }

    public void addTrigegr(final Trigger trigger) {
        this.triggers.put(trigger.getName(), trigger);
    }

    @Override
    public String toString() {
        return "CardDefinition{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", description=" + description +
                ", triggers=" + triggers +
                '}';
    }
}
