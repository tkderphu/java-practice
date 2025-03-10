package generation;

import java.util.Arrays;
import java.util.Scanner;

public class DSA01020 {

    public  static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int t =Integer.parseInt(input.nextLine());
        while(t -- > 0) {
            String s = input.nextLine();
            char a[] = s.toCharArray();
            boolean isConfigEnd = prevBinary(a);
            System.out.println(String.valueOf(a));
        }
    }

    private static boolean prevBinary(char[] a) {
        int i = a.length - 1;
        while(i >= 0 && a[i] == '0') {
            a[i] = '1';
            i--;
        }
        if(i >= 0) {
            a[i] = '0';
            return false;
        }
        return true;
    }

}
