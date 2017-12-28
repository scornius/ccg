package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;

public class FilteringCollectingCardVisitor extends CollectingCardVisitor {

    private final CardFilter[] filters;

    public FilteringCollectingCardVisitor(final CardFilter[] filters) {
        this.filters = filters;
    }

    @Override
    public void visit(final Card card) {

        boolean matches = true;

        for (final CardFilter filter : filters) {
            matches &= filter.matches(card);
        }

        if (matches) {
            addCard(card);
        }
    }

}
