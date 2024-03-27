public class Board {

    private final Ship[][] grid;

    public Board(int size) {
        if (size > 15) throw new InvalidBoardSizeException();
        else grid = new Ship[size][size];
    }

    public void placeShipHorizontal(Ship ship, Point p) {
        for (int i = 0; i < ship.size(); i++)
            placeShip(new Point(p.x(), p.y() + i), ship);
    }

    public void placeShipVertical(Ship ship, Point p) {
        for (int i = 0; i < ship.size(); i++)
            placeShip(new Point(p.x() + i, p.y()), ship);
    }

    public Ship shipAt(Point p) {
        try {
            return grid[p.x()][p.y()];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidShipPositionException();
        }
    }

    private void placeShip(Point p, Ship ship) {
        try {
            grid[p.x()][p.y()] = ship;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidShipPositionException();
        }
    }

    @Override
    public String toString() {
        return String.format("%dx%d", grid.length, grid.length);
    }

}
