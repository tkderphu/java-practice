package generation;

import java.util.Arrays;
import java.util.Scanner;

public class DSA01027 {

    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        int p[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            p[i] = i + 1;
        }
        Arrays.sort(a);
        boolean isConfigEnd = false;
        while(!isConfigEnd) {
            for(int i = 0; i < n; i++) {
                System.out.print(a[p[i] - 1] + " ");
            }
            System.out.println();
            isConfigEnd = nextPermutation(a, n);
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
