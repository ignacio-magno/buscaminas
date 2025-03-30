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

    @Test
    public void game23(){
        int x = 2;
        int y = 3;

        int xinit = x -1;
        int yinit = y -1;

        for (int i = 0; i <  9; i++) {
            int x1 = xinit + i % 3;
            int y1 = yinit + i / 3;

            System.out.println("Checking " + x1 + "," + y1);
        }
    }

    private void CheckCellIsNumber(Logic.Cell cell, int content) {
        assert cell instanceof Logic.CellNumber;
        assert ((Logic.CellNumber) cell).getNumber() == content;
    }
}
