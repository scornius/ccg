package org.nerdizin.ccg.entities;

public class Trigger {

    private String name;
    private String script;

    public Trigger(final String name, final String script) {
        this.name = name;
        this.script = script;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(final String script) {
        this.script = script;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "name='" + name + '\'' +
                ", script='" + script + '\'' +
                '}';
    }
}
