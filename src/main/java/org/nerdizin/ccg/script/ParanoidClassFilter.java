package org.nerdizin.ccg.script;

import jdk.nashorn.api.scripting.ClassFilter;

public class ParanoidClassFilter implements ClassFilter {

    @Override
    public boolean exposeToScripts(final String className) {
        return className.startsWith("org.nerdizin.ccg");
    }
}
