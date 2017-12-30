package org.nerdizin.ccg.script;

import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.game.Game;
import org.nerdizin.ccg.game.Player;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ScriptRunnerTest {

    @Test
    void testClassFilter() {

        final ScriptRunner scriptRunner = new ScriptRunner(createGame());
        assertThrows(RuntimeException.class,
                () -> scriptRunner.runScript("var File = Java.type(\"java.io.File\");"));
    }

    @Test
    void testScript() {

        final ScriptRunner scriptRunner = new ScriptRunner(createGame());
        final String result = (String) scriptRunner.runScript("print('game: ' + game);");
        System.out.println(result);
    }

    private Game createGame() {
        final Game game = new Game();
        game.addPlayer(new Player("Alphons"));
        game.addPlayer(new Player("Berthold"));
        return game;
    }

}