package org.nerdizin.ccg.util;

import org.nerdizin.ccg.entities.Card;
import org.nerdizin.ccg.entities.CardDefinition;
import org.nerdizin.ccg.entities.LocalizedText;

import java.util.Locale;

public class CardPrinter {

    public static String printCard(final Card card, final Locale locale) {

        final CardDefinition cardDefinition = card.getCardDefinition();
        final StringBuffer result = new StringBuffer();
        result.append(printLocalizedText(cardDefinition.getName(), locale)).append("\n");
        result.append(cardDefinition.getType().getLocalizedName(locale));
        return result.toString();
    }

    private static String printLocalizedText(final LocalizedText localizedText, final Locale locale) {
        return localizedText.getLocalizedText(locale);
    }
}
