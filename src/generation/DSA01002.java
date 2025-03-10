package generation;

import java.util.Scanner;

public class DSA01002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int arr[] = new int[k];
            for(int i = 0; i < k; i++) arr[i] = input.nextInt();
            boolean isConfigEnd = nextCombination(arr, n, k);
            if(!isConfigEnd) for(int x : arr) System.out.print(x + " ");
            else for(int i = 1; i <= k; i++) System.out.print(i + " ");
            System.out.println();
        }
    }

    private static boolean nextCombination(int[] arr, int n, int k) {
        int i = k - 1;
        while(i >= 0 && arr[i] >= n - k + i + 1) i--;
        if(i >= 0) {
            arr[i] += 1;
            for(int j = i + 1; j < k; j++) arr[j] = arr[i] + j - i;
            return false;
        }
        return true;
    }
}
