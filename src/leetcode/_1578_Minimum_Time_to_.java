package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1578_Minimum_Time_to_ {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = colors.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char x = chars[i];
            if(map.containsKey(x)) {
                int index = map.get(x);
                if(i - index == 1) {
                    minTime += Math.min(neededTime[i], neededTime[index]);
                    if(neededTime[i] < neededTime[index]) {

                        swap(i, index, neededTime);
                    }
                }
            }
            map.put(x, i);
        }
//        swap2(i, index, chars);
        return minTime;
    }

    public void swap(int x, int y, int arr[]) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = arr[x];
    }
    public void swap2(int x, int y, char arr[]) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = arr[x];
    }


    public static void main(String[] args) {
    new _1578_Minimum_Time_to_().minCost("aaabbbabbbb", new int[]{
            3,5,10,7,5,3,5,5,4,8,1
    });
    }
}
