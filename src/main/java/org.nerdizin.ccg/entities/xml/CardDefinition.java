package org.nerdizin.ccg.entities.xml;

import org.nerdizin.ccg.entities.CardType;
import org.nerdizin.ccg.entities.LocalizedText;

public class CardDefinition {

    private int id;
    private LocalizedText name;
    private CardType type;
    private LocalizedText description;

    public CardDefinition() {
        name = new LocalizedText();
        description = new LocalizedText();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
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

    @Override
    public String toString() {
        return "CardDefinition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description=" + description +
                '}';
    }
}
