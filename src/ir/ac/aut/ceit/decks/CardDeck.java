package ir.ac.aut.ceit.decks;

import ir.ac.aut.ceit.cards.Card;

public class CardDeck extends ObjectDeck {


    public CardDeck(Card... cards) {
        super(cards);
    }

    @Override
    public Card deal() {
        return (Card) super.deal();
    }


}
