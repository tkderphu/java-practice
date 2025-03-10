package code_ptit.practice.wordset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordSet {
    private Set<String> set;
    public WordSet(String line) {
        this.set = new HashSet<>();
        String[] words = line.trim().toLowerCase()
                .split("\\s+");
        for(String word : words) {
            set.add(word);
        }
    }
    public WordSet(Set<String> wordSet) {
        this.set = wordSet;
    }
    public WordSet intersection(WordSet b) {
        TreeSet<String> newSet = new TreeSet<>(this.set);
        newSet.retainAll(b.set);
        return new WordSet(newSet);
    }

    public WordSet union(WordSet b) {
        TreeSet<String> newSet = new TreeSet<>(this.set);
        newSet.addAll(b.set);
        return new WordSet(newSet);
    }

    @Override
    public String toString() {
        String s = "";
        for(String x : set) {
            s += x + " ";
        }
        return s;
    }
}
