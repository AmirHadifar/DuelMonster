package ir.ac.aut.ceit.decks;

public abstract class ObjectDeck {

    private Object[] objects;

    public ObjectDeck(Object[] objects) {
        this.objects = objects;
    }

    public Object deal() {
        if (objects == null || objects.length == 0) {
            return null;
        } else {
            Object object = objects[objects.length - 1];
            objects = deleteItem();
            return object;
        }
    }

    private Object[] deleteItem() {
        Object[] o = new Object[objects.length - 1];
        System.arraycopy(objects, 0, o, 0, o.length);
        return o;
    }

    public int size() {
        return objects != null ? objects.length : 0;
    }

    public boolean isEmpty() {
        return objects == null || objects.length == 0;
    }
}
