package generation;

import java.util.Scanner;

public class CTDL_003 {
    public static void main(String [] g) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int w = input.nextInt();
        int c[] = new int[n];
        int a[] = new int[n];
        for(int i = 0; i < n; i++) c[i] = input.nextInt();
        for(int i = 0; i < n; i++) a[i] = input.nextInt();
        int x[] = new int[n];
        int f_opt = Integer.MIN_VALUE;
        String x_opt = "";
        boolean isConfigEnd = false;
        while(!isConfigEnd) {
            int sum = 0;
            int weight = 0;
            for(int i = 0; i < a.length; i++) {
                sum += c[i] * x[i];
                weight += a[i] * x[i];
            }
            if(weight <= w && f_opt < sum) {
                f_opt = sum;
                x_opt = "";
                for(int v : x) x_opt += v + " ";
            }
            isConfigEnd = nextBinary(x);
        }
        System.out.println(f_opt);
        System.out.println(x_opt);
    }

    private static boolean nextBinary(int[] x) {
        int i = x.length - 1;
        while(i >= 0 && x[i] != 0) {
            x[i] = 0;
            i--;
        }
        if(i >= 0) {
            x[i] = 1; return false;
        } return true;
    }
}
