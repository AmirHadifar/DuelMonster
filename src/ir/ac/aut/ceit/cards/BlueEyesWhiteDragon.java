package ir.ac.aut.ceit.cards;

import ir.ac.aut.ceit.world.Field;

public class BlueEyesWhiteDragon extends MonsterCard implements Special {

    private static final int DEFAULT_DRAGON_POWER = 3000;

    public BlueEyesWhiteDragon() {
        super("Blue Eyes White Dragon", "The best card.", DEFAULT_DRAGON_POWER, true);
    }

    @Override
    public void instantEffect(Field owner, Field enemy) {
        owner.addMonsterCard(new BlueEyesWhiteDragon());
        owner.addMonsterCard(new BlueEyesWhiteDragon());
    }
}
