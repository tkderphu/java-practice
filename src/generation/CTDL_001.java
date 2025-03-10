package generation;

import java.util.Scanner;
public class CTDL_001 {
    //Review Generation
    public static void main(String[] args) {
        System.out.println("dsa".lastIndexOf('('));
    }

    private static void showResult(int n) {
        int[] arr = new int[n];
        boolean isConfigEnd = false;
        while(!isConfigEnd) {
            if(check(arr)) {
                for(int x : arr) System.out.print(x + " ");
                System.out.println();
            }
            isConfigEnd = nextBinary(arr);
        }
    }

    /**
     * Function: kiem tra xem co thuan nghich
     * @param arr: mang ma nhi phan
     * @return true -> thuan nghich
     * false -> khong thuan nghich
     */
    private static boolean check(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while(l < r) {
            if(arr[l] != arr[r]) return false;
            l ++; r--;
        }
        return true;
    }

    /**
     * Fucntion: Lay ma nhi phan ke tiep
     * @param arr: mang chua day nhi phan
     * @return: return false neu chua phai cau hinh cuoi
     * return true -> da la cau hinh cuoi cung
     */
    public static boolean nextBinary(int arr[]) {
        int i = arr.length - 1;
        while(i >= 0 && arr[i] == 1) {
            arr[i] = 0;
            i--;
        }
        if(i >= 0) {
            arr[i] = 1;
            return false;
        }
        return true;
    }


}
