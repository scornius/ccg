package org.nerdizin.ccg.filter;

import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.CardType;

public class TypeFilter implements CardFilter {

    private final CardType type;

    public TypeFilter(final CardType type) {
        this.type = type;
    }

    @Override
    public boolean matches(final Card card) {
        return card.getCardDefinition().getType() == type;
    }
}
