package ir.ac.aut.ceit.cards;

public class MonsterCard extends Card {

    private int power;
    private int basePower;
    private boolean canAttack;

    public MonsterCard(String name, String description, int power, boolean canAttack) {
        super(name, description);
        this.power = power;
        this.canAttack = canAttack;
        this.basePower = 1500;
    }

    public MonsterCard(String name, String description, int power) {
        this(name, description, power, false);
    }

    @Override
    public String toString() {
        return String.format("%s | Power: %d | Can attack: %b", super.toString(), power, canAttack);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof MonsterCard)) return false;

        MonsterCard that = (MonsterCard) o;

        if (power != that.power) return false;
        if (basePower != that.basePower) return false;
        if (canAttack != that.canAttack) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        result = 31 * result + basePower;
        result = 31 * result + (canAttack ? 1 : 0);
        return result;
    }

    public int getPower() {
        return power;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
