package org.nerdizin.ccg.script;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.nerdizin.ccg.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ScriptRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptRunner.class.getName());

    private final Game game;
    private final NashornScriptEngineFactory factory;

    public ScriptRunner(final Game game) {
        this.game = game;
        factory = new NashornScriptEngineFactory();
    }

    public Object runScript(final String script) {

        final ScriptEngine engine = factory.getScriptEngine(new ParanoidClassFilter());
        engine.getContext().setAttribute("game", game, ScriptContext.ENGINE_SCOPE);
        engine.getContext().setAttribute("player", game.getActivePlayer(), ScriptContext.ENGINE_SCOPE);

        try {
            return engine.eval(script);
        } catch (ScriptException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
}
