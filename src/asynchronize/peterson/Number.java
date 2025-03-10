package asynchronize.peterson;

public class Number {
    private int value;
    public Number(int value) {
        this.value = value;
    }

    public void plus(int x) {
        this.value += x;
    }
    public void minus(int x) {
        this.value -= x;
    }

    public int getValue() {
        return value;
    }
}
