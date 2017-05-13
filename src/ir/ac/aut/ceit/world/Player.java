package ir.ac.aut.ceit.world;

import ir.ac.aut.ceit.cards.*;
import ir.ac.aut.ceit.decks.CardDeck;
import ir.ac.aut.ceit.decks.SpecialDeck;

public class Player {

    private static final int DEFAULT_LIFE_POINTS = 5000;

    private CardDeck mainDeck;
    private SpecialDeck specialDeck;
    private Card[] hand;
    private Special nextSpecial;
    private int lifePoint;

    public Player(CardDeck mainDeck, SpecialDeck specialDeck, int lifePoint) {
        this.mainDeck = mainDeck;
        this.specialDeck = specialDeck;
        this.lifePoint = lifePoint;
        this.hand = new Card[5];
    }

    public Player(CardDeck mainDeck, SpecialDeck specialDeck) {
        this(mainDeck, specialDeck, DEFAULT_LIFE_POINTS);
    }

    public boolean draw(int count) {
        boolean successful = true;
        for (int i = 0; i < count; i++) {
            Card card = mainDeck.deal();
            if (card != null) {
                hand[i] = card;
            } else {
                successful = false;
            }
        }
        return successful;
    }

    public void drawSpecialCard() {
        if (nextSpecial == null) {
            nextSpecial = specialDeck.deal();
        }
    }

    public void nextTurnPrep() {
        if (!draw(1)) {
            changeLifePoints(-500);
        }
        drawSpecialCard();
    }


    public boolean playCardFromHand(int whichCard, Field myField) {
        if (whichCard > 4 || hand[whichCard] == null) {
            return false;
        } else {
            if (hand[whichCard] instanceof SpellCard) {
                SpellCard spellCards = (SpellCard) hand[whichCard];
                hand[whichCard] = null;
                return myField.addSpellCard(spellCards);
            } else {
                MonsterCard monsterCard = (MonsterCard) hand[whichCard];
                hand[whichCard] = null;
                return myField.addMonsterCard(monsterCard);
            }

        }
    }

    public boolean playSpecial(Field myField) {
        boolean success = false;
        if (nextSpecial != null) {
            if (nextSpecial instanceof MonsterCard) {
                success = myField.addMonsterCard((MonsterCard) nextSpecial);
            } else if (nextSpecial instanceof SpellCard) {
                success = myField.addSpellCard((SpellCard) nextSpecial);
            } else {
                success = nextSpecial instanceof TrapCard;
            }
        }
        nextSpecial = null;
        return success;
    }


    public boolean isDefeated() {
        return lifePoint <= 0;
    }


    public Card[] getHand() {
        return hand;
    }

    public Special getNextSpecial() {
        return nextSpecial;
    }

    public int getLifePoints() {
        return lifePoint;
    }

    public void changeLifePoints(int lifePoint) {
        this.lifePoint += lifePoint;
    }
}
