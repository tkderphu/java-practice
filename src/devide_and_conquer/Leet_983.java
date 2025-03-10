package devide_and_conquer;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Leet_983 {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new TreeSet<>();
        for(int x : days) {
            set.add(x);
        }
        int dp[] = new int[366];
        return solve(set, costs, 365, dp);
    }

    public int solve(Set<Integer> days, int[] costs, int i, int[] dp) {
        if(i == 0) {
            return 0;
        }
        if(dp[i] != 0) {
            return dp[i];
        }
        if(!days.contains((Integer) i)) {
            dp[i] =  solve(days, costs, i - 1, dp);
        }
        dp[i] =  Math.min(solve(days, costs, Math.max(i - 7, 0), dp) + costs[1],
                Math.min(solve(days, costs, Math.max(i - 30, 0), dp) + costs[2],
                        solve(days, costs, i - 1, dp) + costs[0]));
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new Leet_983().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));;
    }
}
