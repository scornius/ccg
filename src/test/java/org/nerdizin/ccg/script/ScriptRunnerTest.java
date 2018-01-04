package org.nerdizin.ccg.script;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nerdizin.ccg.game.Game;
import org.nerdizin.ccg.game.Player;
import org.nerdizin.ccg.test.CardFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ScriptRunnerTest {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptRunnerTest.class.getName());

    private static CardFactory cardFactory;

    @BeforeAll
    static void init() {
        cardFactory = new CardFactory();
    }

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
        LOG.info(result);
    }

    @Test
    void testAddResource() {

        final Game game = createGame();
        LOG.info(game.toString());

        final StringBuilder script = new StringBuilder();
        script.append("player.pool.addGold(1);");

        final ScriptRunner scriptRunner = new ScriptRunner(game);
        scriptRunner.runScript(script.toString());

        LOG.info(game.toString());
    }

    private Game createGame() {
        final Game game = new Game();
        game.addPlayer(new Player("Alphons"));
        game.addPlayer(new Player("Berthold"));
        game.setActivePlayer(game.getPlayers().get(0));
        return game;
    }

}