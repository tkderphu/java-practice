package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leet_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while(r < nums.length) {
            sum += nums[r];
            while(sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        String input = "Hello {name}, hello guys {userId} {6}";
        String regex = "\\{([^}]+)\\}"; // Match placeholders like {name} and {userId}

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        System.out.println(pattern.pattern());
        List<String> placeholders = new ArrayList<>();
        while (matcher.find()) {
            placeholders.add(matcher.group(1)); // Extract the content inside {}
        }

        System.out.println("Extracted placeholders: " + placeholders);
    }
}
