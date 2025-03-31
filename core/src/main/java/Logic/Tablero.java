package Logic;

public class Tablero {
    Matrix matrix;
    private boolean win = false;

    public Tablero(Matrix matrix) {
        this.matrix = matrix;
    }

    public TurnResult Click(int i, int i1) {
        matrix.onClickUser(i + 1, i1 +1);
        setWin();

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

    public boolean Win() {
        return win;
    }

    public boolean Lose(){
        return matrix.Lose;
    }

    private void setWin(){
        // Itera sobre todas las matrices y si encuentra alguno que no sea una mina o una mina escondida, retorna falso
        for (int i = 0; i < matrix.matrix.length; i++) {
            for (int j = 0; j < matrix.matrix[0].length; j++) {
                Cell cell = matrix.matrix[i][j];
                if ((cell instanceof CellMine) || cell instanceof CellNotOpened) {
                    return;
                }
            }
        }

        win = true;
    }
}

