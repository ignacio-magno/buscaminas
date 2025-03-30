package Logic;

public class CellNumber extends Cell {
    private int number;

    public CellNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String content() {
        return Integer.toString(number);
    }
}
