package Logic;

public class CellWithCoordinates{
    private final Cell cell;
    private int x;
    private int y;

    public CellWithCoordinates(int x, int y, Cell cell) {
        this.x = x;
        this.y = y;
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
