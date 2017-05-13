package ir.ac.aut.ceit.cards;


public abstract class TrapCard extends Card implements Special {


    public TrapCard(String name, String description) {
        super(name, description);
    }


    //todo implement isEqual properly
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        return o instanceof TrapCard;
    }
}
