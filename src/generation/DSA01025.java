package generation;

import java.util.Scanner;

public class DSA01025 {
    public static void main(String [] g) {
        Scanner input = new Scanner(System.in);
        int t=input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[k];
            for(int i = 0; i < k; i++) arr[i] = i + 1;
            boolean isConfigEnd = false;
            while(!isConfigEnd) {
                for(int i = 0; i < arr.length; i++) {
                    System.out.print((char)('A' + arr[i] - 1));
                }
                System.out.println();
                isConfigEnd = nextCombination(arr, n, k);
            }
        }
    }

    private static boolean nextCombination(int[] arr, int n, int k) {
        int i = k - 1;
        while(i >= 0 && arr[i] >= n - k + i + 1) i--;
        if(i >= 0) {
            arr[i] += 1;
            for(int j = i + 1; j < k; j++) arr[j] = arr[i] + j - i;
            return false;
        } return true;
    }
}
