package leetcode;

import java.util.*;

public class LeetCode_17_phone_number {
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty() || digits.isBlank()) return Collections.emptyList();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
         generateCombination(digits, map, 0, "", res);
         return res;
    }

    private static void generateCombination(String digits,
                                       Map<Character, String> map,
                                       int start,
                                       String s,
                                       List<String> res) {
        for(int i = start; i < digits.length(); i++) {
            for(char x : map.get(digits.charAt(i)).toCharArray()) {
                String cm = s + x;
                generateCombination(digits, map, i + 1, cm, res);
                if(cm.length() == digits.length()) {
                    res.add(cm);
                }
            }
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
