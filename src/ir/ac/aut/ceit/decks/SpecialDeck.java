package ir.ac.aut.ceit.decks;

import ir.ac.aut.ceit.cards.Special;

public class SpecialDeck extends ObjectDeck {

    public SpecialDeck(Special... specials) {
        super(specials);
    }

    @Override
    public Special deal() {
        return (Special) super.deal();
    }


}
