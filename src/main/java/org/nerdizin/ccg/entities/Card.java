package org.nerdizin.ccg.entities;

import org.nerdizin.ccg.filter.CardVisitor;
import org.nerdizin.ccg.filter.VisitableCard;

public class Card implements VisitableCard {

    private CardDefinition cardDefinition;


    public Card(final CardDefinition cardDefinition) {
        this.cardDefinition = cardDefinition;
    }

    @Override
    public void accept(final CardVisitor cardVisitor) {
        cardVisitor.visit(this);
    }

    public CardDefinition getCardDefinition() {
        return cardDefinition;
    }

    public void setCardDefinition(final CardDefinition cardDefinition) {
        this.cardDefinition = cardDefinition;
    }
}
