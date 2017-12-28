package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;

public interface CardFilter {

    boolean matches(final Card card);
}
