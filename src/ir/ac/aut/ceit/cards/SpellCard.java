package ir.ac.aut.ceit.cards;

import ir.ac.aut.ceit.world.Field;

public abstract class SpellCard extends Card {


    public SpellCard(String name, String description) {
        super(name, description);
    }

    public abstract void turnEffect(Field ownerField, Field enemyField);

    public abstract void destroyedEffect(Field ownerField, Field enemyField);


    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        if (!(o instanceof SpellCard)) return false;
        return true;
    }
}
