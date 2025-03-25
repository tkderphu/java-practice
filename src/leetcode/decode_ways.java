package leetcode;

public class decode_ways {
    public int numDecodings(String s) {
        return solve(s,s.charAt(0) + "", 0);
    }
    public int  solve(String s,String res, int index) {

        index += 1;
        if(res.length() >= 3) return 0;
        if(res.charAt(0) == '0') return 0;
        if(res.length() == 2 && res.charAt(1) > '6') return 0;
        if(index >= s.length()) return 1;
        int ans = solve(s, res + s.charAt(index), index) + solve(s, s.charAt(index) + "", index);

        return ans;
    }

    public static void main(String[] args) {
        new decode_ways().numDecodings("1201234");
    }
}
