package leetcode;

import java.util.*;

public class valid_palindrome {

    public boolean validPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), i);
            }
        }

        if(map.size() == 1) return true;
        if(map.size() == 2) {
            List<Integer> list = new ArrayList<>(map.values());
            return Math.abs(list.get(0) - list.get(1)) == 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
