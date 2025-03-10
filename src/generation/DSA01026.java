package generation;

import java.util.Arrays;
import java.util.Scanner;

public class DSA01026 {
    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[] a = new char[n];
        Arrays.fill(a, '6');
        boolean isConfigEnd = nextBinary(a);
        while(!isConfigEnd) {
            if(check(a)) {
                System.out.println(String.valueOf(a));
            }
            isConfigEnd = nextBinary(a);
        }
    }

    private static boolean check(char[] a) {
        if(a[0] != '8' || a[a.length - 1] != '6') return false;
        char x = '8';
        for(int i = 1; i < a.length; i++) {
            if(x == '8' && x == a[i]) return false;
            else x = a[i];
        }
        x = '6';
        int c = 1;
        for(int i = a.length - 2; i >= 0; i--) {
            if(x == '6' && x == a[i]) {
                c++;
            } else {
                if(c > 3) return false;
                c = 1;
                x = a[i];
            }
        }
        return true;
    }

    private static boolean nextBinary(char[] a) {
        int i = a.length -  1;
        while(i >= 0 && a[i] != '6') {
            a[i] = '6'; i--;
        }
        if(i >= 0) {
            a[i] = '8';
            return false;
        } return true;
    }
}
