package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;

public class IdFilter implements CardFilter {

    private final String id;

    public IdFilter(final String id) {
        this.id = id;
    }

    @Override
    public boolean matches(final Card card) {
        return card.getCardDefinition().getId().equalsIgnoreCase(id);
    }
}
