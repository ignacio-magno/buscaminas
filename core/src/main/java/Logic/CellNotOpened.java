package Logic;

// Es una celda que no ha sido tocada.
public class CellNotOpened extends Cell {
    public CellNotOpened() {
    }

    @Override
    public String content() {
        return "X";
    }
}
