package asynchronize.peterson;

public class Maintain {
    private int turn;
    private boolean flag[] = new boolean[2];

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean[] getFlag() {
        return flag;
    }

    public void setFlag(int process, boolean flag) {
        this.flag[process] = false;
    }


}
