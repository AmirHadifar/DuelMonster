package ir.ac.aut.ceit.cards;

import ir.ac.aut.ceit.world.Field;

public class DestroySpell extends TrapCard {

    public DestroySpell() {
        super("Destroy Spell", "Destroys the enemy’s first spell card.");
    }

    @Override
    public void instantEffect(Field owner, Field enemy) {
        if (enemy.getSpells() != null && enemy.getSpells().length > 0) {
            for (int i = 0; i < enemy.getSpells().length; i++) {
                if (enemy.getSpells()[i] != null) {
                    enemy.getSpells()[i].destroyedEffect(owner, enemy);
                    break;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof DestroySpell;
    }
}
