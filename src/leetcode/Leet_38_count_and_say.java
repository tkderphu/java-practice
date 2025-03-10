package leetcode;

public class Leet_38_count_and_say {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String res = "1";
        return solve(n, res);
    }

    private String solve(int n, String res) {
        if(n <= 1) {
            return res;
        }
        int l = 0;
        int r = 1;
        StringBuffer builder = new StringBuffer();
        while(r < res.length()) {
            if(res.charAt(r) != res.charAt(l)) {
                builder.append(returnStr(l, r, res));
                l = r;
            }
            r++;
        }
        builder.append(returnStr(l, r, res));

        return solve(n - 1, builder.toString());
    }
    public String returnStr(int l, int r, String res) {
        int repeat = r - l ;
        return repeat + "" + res.charAt(l);
    }

    public static void main(String[] args) {
        new Leet_38_count_and_say().countAndSay(4);
    }
}
