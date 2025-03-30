package Logic;

public class TableroBuilder {
    Matrix matrix;

    private TableroBuilder(Matrix matrix) {
        this.matrix = matrix;
    }

    public static TableroBuilder Create(int ancho, int alto) {
        return  new TableroBuilder(new Matrix(ancho, alto));
    }

    public TableroBuilder WithMines(int i) {
        matrix.addMines(i);
        return this;
    }

    public TableroBuilder WithMines(int i, int i1) {
        matrix.addMinesUser(i, i1);
        return this;
    }

    public Tablero Build() {
        return new Tablero(matrix);
    }
}
