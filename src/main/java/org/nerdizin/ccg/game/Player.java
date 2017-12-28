package org.nerdizin.ccg.game;

import org.nerdizin.ccg.entities.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> library = new ArrayList<>();
    private List<Card> graveyard = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();
    private ResourcePool pool = new ResourcePool();

    public Player(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Card> getLibrary() {
        return library;
    }

    public void setLibrary(final List<Card> library) {
        this.library = library;
    }

    public List<Card> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(final List<Card> graveyard) {
        this.graveyard = graveyard;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(final List<Card> hand) {
        this.hand = hand;
    }

    public ResourcePool getPool() {
        return pool;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", library=" + library +
                ", graveyard=" + graveyard +
                ", hand=" + hand +
                ", pool=" + pool +
                '}';
    }
}
