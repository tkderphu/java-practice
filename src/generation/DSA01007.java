package generation;

import java.util.Arrays;
import java.util.Scanner;

public class DSA01007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            char[] binarys = new char[n];
            Arrays.fill(binarys, 'A');
            boolean isConfigEnd = false;
            while(!isConfigEnd) {
                System.out.print(String.valueOf(binarys) + " ");
                isConfigEnd = nextBinary(binarys);
            }
            System.out.println();
        }
    }
    public static boolean nextBinary(char arr[]) {
        int i = arr.length - 1;
        while(i >= 0 && arr[i] == 'B') {
            arr[i] = 'A';
            i--;
        }
        if(i >= 0) {
            arr[i] = 'B';
            return false;
        }
        return true;
    }
}
