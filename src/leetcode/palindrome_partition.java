package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class palindrome_partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solve(0, res, list, s);
        return res;
    }

    public void solve(int index, List<List<String>> res, List<String> list, String s) {
        if(index == s.length()) {
            res.add(list.stream()
                    .map(str -> str.substring(0, str.lastIndexOf("_-_")))
                    .collect(Collectors.toList()));
        }
        String concat = "";
        for(int i = index; i < s.length(); i++) {
            concat += s.charAt(i);
            if(palinDrome(concat)) {
                list.add(concat);
                solve(i + 1, res, list, s);
            }
            list.remove(concat + "_-_" + i);
        }
    }
    public boolean palinDrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }

    public static void main(String[] args) {
        new palindrome_partition().partition("aab");
    }
}
