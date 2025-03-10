package generation;

import java.util.Scanner;

public class DSA01022 {
    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int a[] = new int[n];
            int r[] = new int[n];
            for(int i = 0; i < n; i++) {
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
                isConfigEnd = nextPermutation(r);
            }
            System.out.println(c);
        }
    }

    private static boolean match(int[] a, int[] r) {
        int c = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == r[i]) c++;
        }
        if(c == a.length) return true;
        return false;
    }

    private static boolean nextPermutation(int[] r) {
        int i = r.length - 2;
        while(i >= 0 && r[i] >= r[i + 1]) i--;
        if(i >= 0) {
            int k = r.length - 1;
            while(r[i] > r[k]) k--;
            swap(r, i, k);
            int l = i + 1;
            int m = r.length - 1;
            while(l < m) {
                swap(r, l, m); l ++; m--;
            }
            return false;
        }
        return true;
    }

    private static void swap(int[] r, int i, int k) {
        int tmp= r[i]; r[i] = r[k]; r[k] =tmp;
    }
}
