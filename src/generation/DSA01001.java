package generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DSA01001 {
    //Review Generation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        while(n -- > 0) {
            String s = input.nextLine();
            char[] binarys = s.toCharArray();
            nextBinary(binarys);
            System.out.println(String.valueOf(binarys));
        }
    }

    /**
     * Fucntion: Lay ma nhi phan ke tiep
     * @param arr: mang chua day nhi phan
     * @return: return false neu chua phai cau hinh cuoi
     * return true -> da la cau hinh cuoi cung
     */
    public static boolean nextBinary(char arr[]) {
        int i = arr.length - 1;
        while(i >= 0 && arr[i] == '1') {
            arr[i] = '0';
            i--;
        }
        if(i >= 0) {
            arr[i] = '1';
            return false;
        }
        return true;
    }


}
