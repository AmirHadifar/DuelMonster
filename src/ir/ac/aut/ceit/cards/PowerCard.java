package ir.ac.aut.ceit.cards;

import ir.ac.aut.ceit.world.Field;

public class PowerCard extends SpellCard {

    @Override
    public void turnEffect(Field ownerField, Field enemyField) {
        for (int i = 0; i < 5; i++) {
            MonsterCard monsterCard = ownerField.getMonsters()[i];
            if (monsterCard != null) {
                ownerField.getMonsters()[i].setPower(monsterCard.getPower() + 100);
            }
        }
    }

    @Override
    public void destroyedEffect(Field ownerField, Field enemyField) {
        for (int i = 0; i < 5; i++) {
            MonsterCard monsterCard = ownerField.getMonsters()[i];
            if (monsterCard != null) {
                ownerField.getMonsters()[i].setPower(monsterCard.getPower() - 300);
            }
        }
    }

    public PowerCard() {
        super("Power Card", "Increases power of monsters by 100 each turn.");
    }
}
