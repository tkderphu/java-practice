package code_ptit.practice.graph;

public class Pair <K, V>{
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", key, value);
    }
}
