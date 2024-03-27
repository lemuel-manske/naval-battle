public class Ship {

    private final int size;

    public Ship(int size) {
        this.size = size;
    }

    public static Part part() {
        return new Part();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Ship ship = (Ship) o;
        return ship.size == size;
    }

    public Chain chain() {
        Chain chain = new Chain();

        for (int i = 0; i < size; i++)
            chain.add(new Part());

        return chain;
    }

    protected static class Part {
    }
}
