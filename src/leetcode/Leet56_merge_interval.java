package leetcode;

import java.util.*;

public class Leet56_merge_interval {
    class Pair implements Comparable<Pair>{
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return this.first - o.first;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            pairs.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs.get(0));
        List<Pair> results = new ArrayList<>();
        for(int i = 1; i < pairs.size(); i++) {
            Pair pop = st.pop();
            if(pop.second >= pairs.get(i).first) {
                Pair pair = new Pair(pop.first, Math.max(pairs.get(i).second, pop.second));
                st.push(pair);
            } else {
                results.add(pop);
                st.push(pairs.get(i));
            }
        }
        results.add(st.pop());
        int[][] res = new int[results.size()][2];
        for(int i = 0; i < results.size(); i++) {
            res[i][0] = results.get(i).first;
            res[i][1] = results.get(i).second;
        }
        return res;
    }

    public static void main(String[] args) {
        new Leet56_merge_interval().merge(new int[][]{
                {1, 3},{2, 6}, {8, 10}, {15, 18}
        });
    }
}
