package generation;

import java.util.Arrays;
import java.util.Scanner;

public class DSA01019 {

    public  static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int t =input.nextInt();
        while(t -- > 0) {
            int n = input.nextInt();
            char a[] = new char[n];
            Arrays.fill(a, 'A');
            boolean isConfigEnd = nextBinary(a);
            while(!isConfigEnd) {
                if(check(a)) {
                    System.out.println(String.valueOf(a));
                }
                isConfigEnd = nextBinary(a);
            }
        }
    }

    private static boolean check(char[] a) {
        if(a[0] != 'H' || a[a.length - 1] != 'A') return false;
        char x = a[0];
        for(int i = 1; i < a.length; i++) {
            if(x == 'H' && x == a[i]) return false;
            else x = a[i];
        }
        return true;
    }

    private static boolean nextBinary(char[] a) {
        int i = a.length - 1;
        while(i >= 0 && a[i] == 'H') {
            a[i] = 'A';
            i--;
        }
        if(i >= 0) {
            a[i] = 'H';
            return false;
        }
        return true;
    }

}
