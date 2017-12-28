package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;

public interface CardVisitor {

    void visit(final Card card);
}
