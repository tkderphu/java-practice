package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class group_anagrams {
    class Pair implements Comparable<Pair>{
        String first;
        String second;
        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return first.compareTo(o.first);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Pair> newArr = new ArrayList<>();
        for(int i = 0; i  < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            newArr.add(new Pair(String.valueOf(charArray), strs[i]));
        }
        Collections.sort(newArr);

        List<List<String>> res = new ArrayList<>();
        List<String> resStr = new ArrayList<>();
        Pair first = newArr.get(0);
        resStr.add(first.second);
        for(int i = 1; i < newArr.size(); i++) {
            if(newArr.get(i).first.equals(first.first)) {
                resStr.add(newArr.get(i).second);
            } else {
                res.add(resStr);
                first = newArr.get(i);
                resStr = new ArrayList<>();
                resStr.add(first.second);
            }
        }
        res.add(resStr);
        return res;
    }

    public static void main(String[] args) {
        new group_anagrams().groupAnagrams(new String[] {
                "eat","tea","tan","ate","nat","bat"
        });
    }
}

