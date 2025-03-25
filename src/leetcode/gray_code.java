package leetcode;

import java.util.ArrayList;
import java.util.List;

public class gray_code {
    public List<Integer> grayCode(int n) {
        int end = (int)Math.pow(2, n) - 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        boolean visited[] = new boolean[end + 1];
        boolean[] flag = new boolean[1];
        solve(n, end, list, 1, visited, flag);
        return list;
    }

    public boolean isDifferOneBit(int x, int y, int n) {
        return Math.abs(Integer.bitCount(x) - Integer.bitCount(y)) == 1;
    }

    public void solve(int n, int end, List<Integer> list, int val, boolean[] visited, boolean[] flag) {
        if (list.size() == end + 1) {
            int max = end;
            boolean isOke = true;
//            if (!isDifferOneBit(list.get(0), list.get(max), n)) {
//                isOke = false;
//            }
            for (int i = 1; i < list.size(); i++) {
                if (!isDifferOneBit(list.get(i), list.get(i - 1), n)) {
                    isOke = false;
                    break;
                }
            }
            if(isOke) {
                flag[0] = true;

            }
            return;
        }
        for (int i = 1; i <= end; i++) {

            if (!visited[i]) {
                visited[i] = true;
                if(flag[0]) return;
                list.add(i);
                solve(n, end, list, i, visited, flag);
                if(flag[0]) return;
                list.remove((Integer) (i));
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        new gray_code().grayCode(2);
    }
}
