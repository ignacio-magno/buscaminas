package Logic;

public class Tablero {
    Matrix matrix;

    public Tablero(Matrix matrix) {
        this.matrix = matrix;
    }

    public TurnResult Click(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cell Cell(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getWidth() {
        return matrix.matrix.length;
    }

    public int getHeight() {
        return matrix.matrix[0].length;
    }
}

