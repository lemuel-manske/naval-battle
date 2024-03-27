public class Ship {

    private final int size;

    public Ship(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Ship ship = (Ship) o;
        return ship.size == size;
    }

}
