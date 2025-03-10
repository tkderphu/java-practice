package generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CTDL_002 {
    //Review Generation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = input.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = input.nextInt();
        showResult(n, res, sum);
    }

    private static void showResult(int n, int[] res, int sum) {
        int[] arr = new int[n];
        boolean isConfigEnd = false;
        List<String> list = new ArrayList<>();
        while(!isConfigEnd) {
            if(check(arr, res, sum)) {
                StringBuilder builder = new StringBuilder();
                for(int i = 0; i < arr.length; i++) {
                    if(arr[i] == 1) builder.append(res[i] + " ");
                }
                list.add(builder.toString());
            }
            isConfigEnd = nextBinary(arr);
        }
        for(String s : list) System.out.println(s);
        System.out.println(list.size());
    }

    /**
     * Fucntion: kiem tra xem tong co bang sum
     * @param arr: ma nhi phan
     * @param res: mang ban dau
     * @param sum
     * @return
     */
    private static boolean check(int[] arr, int[] res, int sum) {
        int s = 0;
        for(int i = 0; i < arr.length; i++) {
            s += arr[i] * res[i];
        }
        if(s == sum) return true;
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
