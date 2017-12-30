package org.nerdizin.ccg.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();
    private Player activePlayer;
    private int turn;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(final Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", activePlayer=" + activePlayer +
                ", turn=" + turn +
                '}';
    }
}
