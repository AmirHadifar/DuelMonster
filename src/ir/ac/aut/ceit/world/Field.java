package ir.ac.aut.ceit.world;

import ir.ac.aut.ceit.cards.MonsterCard;
import ir.ac.aut.ceit.cards.SpellCard;

public class Field {

    private MonsterCard[] monsters = new MonsterCard[5];
    private SpellCard[] spells = new SpellCard[5];


    public void cardTurnEffects(Field enemyField) {
        for (int i = 0; i < 5; i++) {
            if (spells[i] != null) {
                spells[i].turnEffect(this, enemyField);
            }
            if (monsters[i] != null) {
                monsters[i].setCanAttack(true);
            }
        }
    }

    public boolean addMonsterCard(MonsterCard card) {
        for (int i = 0; i < 5; i++) {
            if (monsters[i] == null) {
                monsters[i] = card;
                return true;
            }
        }
        return false;
    }

    public boolean addSpellCard(SpellCard card) {
        for (int i = 0; i < 5; i++) {
            if (spells[i] == null) {
                spells[i] = card;
                return true;
            }
        }
        return false;
    }

    public MonsterCard[] getMonsters() {
        return monsters;
    }

    public SpellCard[] getSpells() {
        return spells;
    }

}
