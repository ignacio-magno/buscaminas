import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
    private Logic.Matrix tablero;

    @Before
    public void setUp() {
        Logic.Matrix tablero = new Logic.Matrix(8, 9);

        tablero.addMinesUser(4, 1);
        tablero.addMinesUser(5, 4);
        tablero.addMinesUser(7, 5);
        this.tablero = tablero;
    }

    @Test
    public void game2() {
        tablero.Draw();
        tablero.onClickUser(7,1);
        tablero.Draw();

        CheckCellIsNumber(tablero.CellUser(5, 1), 1);
        CheckCellIsNumber(tablero.CellUser(5, 2), 1);
        CheckCellIsNumber(tablero.CellUser(5, 3), 1);
        CheckCellIsNumber(tablero.CellUser(6, 3), 1);
        CheckCellIsNumber(tablero.CellUser(6, 4), 2);
        CheckCellIsNumber(tablero.CellUser(7, 4), 1);
        CheckCellIsNumber(tablero.CellUser(8, 4), 1);
    }

    private void CheckCellIsNumber(Logic.Cell cell, int content) {
        assert cell instanceof Logic.CellNumber;
        assert ((Logic.CellNumber) cell).getNumber() == content;
    }
}
