package Logic;

public class Tablero {
    Matrix matrix;

    public Tablero(Matrix matrix) {
        this.matrix = matrix;
    }

    public TurnResult Click(int i, int i1) {
        matrix.onClickUser(i + 1, i1 +1);

        return new TurnResult();
    }

    public Cell Cell(int i, int i1) {
        return matrix.matrix[i][i1];
    }

    public int getWidth() {
        return matrix.matrix.length;
    }

    public int getHeight() {
        return matrix.matrix[0].length;
    }
}

