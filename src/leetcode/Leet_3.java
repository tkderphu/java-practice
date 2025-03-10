package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l) {
                maxLen = Math.max(maxLen, r - l);
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            r ++;
        }
        return Math.max(maxLen, r - l);
    }
}
