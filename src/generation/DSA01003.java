package generation;

import java.util.Scanner;

public class DSA01003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) arr[i] = input.nextInt();
            boolean isConfigEnd = nextPermutation(arr, n);
            if(!isConfigEnd) for(int x : arr) System.out.print(x + " ");
            else for(int i = 1; i <= n; i++) System.out.print(i + " ");
            System.out.println();
        }
    }

    private static boolean nextPermutation(int[] arr, int n) {
        int i = n - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) i--;
        if(i >= 0) {
            int k = n - 1;
            while(arr[i] > arr[k]) k--;
            swap(arr, i, k);
            int l = i + 1;
            int r = n - 1;
            while(l < r) {
                swap(arr, l, r);
                l++; r--;
            }
            return false;
        }
        return true;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp  =arr[l]; arr[l] = arr[r]; arr[r] = tmp;
    }
}
