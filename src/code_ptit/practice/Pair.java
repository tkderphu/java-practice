package code_ptit.practice;

public class Pair <T, S>{

    private T t;
    private S s;

    public Pair(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public boolean isPrime() {
        if(t instanceof Integer && s instanceof Integer) {
            return isPrime((Integer) t) && isPrime((Integer) s);
        }
        return false;
    }

    private boolean isPrime(int x) {
        if(x < 2) return false;

        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return t + " " + s;
    }
}
