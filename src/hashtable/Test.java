package hashtable;

import java.util.*;

public class Test {


    public static boolean ToHopKeTiep(int arr[], int n, int k) {
        int i = k;
        while(i > 0 && arr[i] >= n - k + i) {
            i--;
        }
        if(i > 0) {
            arr[i] += 1;
            for(int j = i + 1; j <= k; j++) {
                arr[j] = arr[i] + j - i;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n + 1];
        for(int i = 1; i <= n; i++) arr[i] = 0;
        showResult(arr, n);

    }

    private static void showResult(int[] res, int n, int sum) {

        int c = 0;
        int k = 2;
        while(k <= n) {
            int[] arr = new int[k + 1];
            for(int i = 1; i <= k; i++) {
                arr[i] = i;
            }
            boolean isExist = false;
            while(!isExist) {
                int s = 0;
                for(int i = 1; i <= k; i++) {
                    s += res[arr[i] - 1];
                }
                if(s == sum) {
                    for(int i = 1; i <= k; i++) {
                        System.out.print(res[arr[i] - 1] + " ");
                    }
                    System.out.println();
                    c++;
                }
                isExist = ToHopKeTiep(arr, n, k);
            }
            k++;
        }
        System.out.println(c);
    }
    public static boolean XauNhiPhan(int arr[], int n) {
        int i = n;
        while(i > 0 && arr[i] != 0) {
            arr[i] = 0;
            i--;
        }
        if(i > 0) {
            arr[i] = 1;
            return false;
        }
        return true;
    }
    public static void showResult(int arr[], int n) {
        boolean isExist = false;
        while(!isExist) {
            boolean isTrue = isPartheti(arr, n);
            if(isTrue) {
                for(int i = 1; i <= n; i++) System.out.print(arr[i] + " ");
                System.out.println();
            }
            isExist = XauNhiPhan(arr, n);
        }
    }

    private static boolean isPartheti(int[] arr, int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            if(arr[l] != arr[r]) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
