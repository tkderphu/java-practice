package leetcode;

public class inter_leaving_string {
    public boolean isInterleave(String s1, String s2, String s3) {
        String res1 = "";
        String res2 = "";
        String res = "";

        String m = s1;
        String n = s2;

        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < s3.length(); ) {
            res += s3.charAt(i);
            boolean isStartWithS1 = m.startsWith(res);
            boolean isStartWithS2 = n.startsWith(res);

            if(isStartWithS1) {
                index1 ++;
                res1  += s3.charAt(i);
                m = m.substring(index1);
            } else if(isStartWithS2) {
                index2 ++;
                res2 += s3.charAt(i);
                n = n.substring(index2);
            } else {
                res =  "";
                continue;
            }
            i++;
        }
        if(res1.equals(s1) && res2.equals(s2)) return true;
        return false;
    }

    public static void main(String[] args) {
        new inter_leaving_string().isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }
}
