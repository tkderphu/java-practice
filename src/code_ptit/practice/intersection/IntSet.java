package code_ptit.practice.intersection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class IntSet {
    private Set<Integer> intSet;

    public IntSet() {
        intSet = new HashSet<>();
    }

    public IntSet(Set<Integer> intSet) {
        this.intSet = intSet;
    }

    public IntSet intersection(IntSet b) {
        Set<Integer> newSet = new TreeSet<>(intSet);
        newSet.retainAll(b.intSet);
        return new IntSet(newSet);
    }

    public IntSet union(IntSet b) {
        Set<Integer> newSet = new TreeSet<>(intSet);
        newSet.addAll(b.intSet);
        return new IntSet(newSet);
    }

    public void add(Integer x) {
        this.intSet.add(x);
    }

    @Override
    public String toString() {
        String res = "";
        for(int x : intSet) {
            res += x + " ";
        }
        return res;
    }

    public IntSet sub(IntSet b) {
        Set<Integer> newSet = new TreeSet<>(intSet);
        newSet.removeAll(b.intSet);
        return new IntSet(newSet);
    }
}
