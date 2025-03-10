package generation;

import java.util.Scanner;

public class DSA01023 {
    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int a[] = new int[k];
            int r[] = new int[k];
            for(int i = 0; i < k; i++) {
                a[i] = input.nextInt();
                r[i] = i + 1;
            }
            int c = 1;
            boolean isConfigEnd = false;
            while(!isConfigEnd) {
                if(match(a, r)) {
                    break;
                }
                c++;
                isConfigEnd = nextCombination(r, n, k);
            }
            System.out.println(c);
        }
    }

    private static boolean nextCombination(int[] r, int n, int k) {
        int i = k - 1;
        while(i >= 0 && r[i] >= n - k + i + 1) i--;
        if(i >= 0) {
            r[i] += 1;
            for(int j = i + 1; j < k; j++) r[j] = r[i] + j - i;
            return false;
        } return true;

    }

    private static boolean match(int[] a, int[] r) {
        int c = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == r[i]) c++;
        }
        if(c == a.length) return true;
        return false;
    }

}
