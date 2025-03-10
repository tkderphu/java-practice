package generation;

import java.util.Scanner;

public class DSA01008 {
    //Review Generation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] binarys = new int[n];
            boolean isConfigEnd = false;
            while(!isConfigEnd) {
                if(check(binarys, k)) {
                    for(int x : binarys) System.out.print(x);
                    System.out.println();
                }
                isConfigEnd = nextBinary(binarys);
            }
        }
    }
    /**
     * Function: kiem tra xem co thuan nghich
     * @param arr : mang ma nhi phan
     * @param k
     * @return true -> thuan nghich
     * false -> khong thuan nghich
     */
    private static boolean check(int[] arr, int k) {
        int c = 0;
        for(int x : arr) if(x == 1) c++;
        if(c == k) return true;
        return false;
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
