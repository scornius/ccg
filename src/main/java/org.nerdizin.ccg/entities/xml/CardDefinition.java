package org.nerdizin.ccg.entities.xml;

public class CardDefinition {

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CardDefinition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
