package org.nerdizin.ccg.filter;

public interface VisitableCard {

    void accept(final CardVisitor cardVisitor);
}
