package generation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DSA01021 {
    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int t =input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int a[] = new int[k];
            Map<Integer, Boolean> m = new HashMap<>();
            for(int i = 0; i < k; i++) {
                a[i] = input.nextInt();
                m.put(a[i], true);
            }
            boolean isConfigEnd = nextCombination(a, n, k);
            if(isConfigEnd) {
                System.out.println(k);
            } else {
                for(int x : a) if(m.containsKey(x)) m.remove(x);
                System.out.println(m.size());
            }
            m.clear();
        }
    }

    private static boolean nextCombination(int[] a, int n, int k) {
        int i = k - 1;
        while(i >= 0 && a[i] >= n - k + i + 1) i--;
        if(i >= 0) {
            a[i] += 1;
            for(int j = i + 1; j < k; j++) a[j] = a[i] + j - i;
            return false;
        }
        return true;
    }
}
