package Logic;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Matrix {
    Cell[][] matrix;
    LinkedHashMap<String, CellWithCoordinates> queue = new LinkedHashMap<>();

    public Matrix(int rows, int columns) {
        matrix = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new CellNotOpened();
            }
        }
    }


    public Cell[][] onClickUser(int xUserCoordinate, int yUserCoordinate) {
        int x = xUserCoordinate - 1;
        int y = yUserCoordinate - 1;

        return onClick(x, y);
    }

    private Cell[][] onClick(int x, int y) {
        System.out.println("Click en " + x + "," + y);

        Cell cell = Cell(x, y);
        if (!(cell instanceof CellNotOpened)) {
            System.out.println("Ya abierto");
            return matrix;
        }

        int minesAround = getMinesAround(x, y);
        System.out.println("Minas alrededor: " + minesAround);

        if (minesAround > 0) {
            matrix[x][y] = new CellNumber(minesAround);
        } else {
            matrix[x][y] = new CellEmpty();
            setCellsToWork(x, y);
        }

        while (!queue.isEmpty()) {
            CellWithCoordinates c = queue.values().iterator().next();
            queue.remove(keyFromCoordinates(c.getX(), c.getY()));
            onClick(c.getX(), c.getY());
        }

        return matrix;
    }

    private int getMinesAround(int x, int y) {
        int minesAround = 0;

        Iterator<CellWithCoordinates> aroundCells = getAroundCells(x, y);

        while (aroundCells.hasNext()) {
            CellWithCoordinates c = aroundCells.next();
            Cell cell = c.getCell();
            int x1 = c.getX();
            int y1 = c.getY();

            if (cell instanceof CellMine) {
                minesAround++;
                System.out.println("Mina encontrada en " + x1 + "," + y1);
            }
        }

        return minesAround;
    }

    private void setCellsToWork(int x, int y) {
        Iterator<CellWithCoordinates> aroundCells = getAroundCells(x, y);

        while (aroundCells.hasNext()) {
            CellWithCoordinates c = aroundCells.next();
            Cell cell = c.getCell();
            int x1 = c.getX();
            int y1 = c.getY();

            if (cell instanceof CellNotOpened) {
                if (queue.containsKey(keyFromCoordinates(x1, y1))) {
                    continue;
                }
                System.out.println("Añadiendo a la cola " + x1 + "," + y1);
                queue.put(keyFromCoordinates(x1, y1), c);
            }
        }
    }

    @NotNull
    private Iterator<CellWithCoordinates> getAroundCells(int xCenter, int yCenter) {
        int xinit = xCenter - 1;
        int yinit = yCenter - 1;

        LinkedList<CellWithCoordinates> aroundCells = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            int x1 = xinit + i % 3;
            int y1 = yinit + i / 3;

            if (x1 < 0 || x1 >= matrix.length || y1 < 0 || y1 >= matrix[0].length) continue;
            if (x1 == xCenter && y1 == yCenter) continue;

            aroundCells.add(new CellWithCoordinates(x1, y1, matrix[x1][y1]));
        }

        return aroundCells.iterator();
    }

    public String keyFromCoordinates(int x, int y) {
        return x + "," + y;
    }

    public void addMines(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void addMinesUser(int x, int y) {
        addMines(x - 1, y - 1);
    }

    private void addMines(int x, int y) {
        matrix[x][y] = new CellMine();
        System.out.println("Mina en " + x + "," + y);
        Draw();
    }
    public Cell CellUser(int x, int y) {
        return matrix[x - 1][y - 1];
    }

    private Cell Cell(int i, int i1) {
        return matrix[i][i1];
    }

    public void Draw() {
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i].content());
            }
            System.out.println();
        }

        System.out.println("____________________");
    }
}
