package code_ptit.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class StackFormation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("SINHVIEN.in"));
        int testCase = Integer.parseInt(input.nextLine());
        while (testCase-- > 0) {
            String str = input.nextLine();
            int newFirst = str.indexOf('(');
            int newLast = str.lastIndexOf(')');
            System.out.println(formatString(
                    str
            ));
        }
    }

    public static String formatString(String s) {

        String result = "";
        int first = s.indexOf('(');
        int last = s.lastIndexOf(')');
        if (first == -1 || last == -1) {
            return s; //calculate
        }
        String res = s.substring(first + 1, last);
        first = res.indexOf('(');
        last = res.lastIndexOf(')');
        while (res.indexOf('(') != -1) {
            String news = formatString(res);
            result += news + res.substring(last + 1);
            res = res.substring(0, first) + result;
        }
        return res;
    }

    private static long calculate(long after, long before, String operand) {
        if (operand.equals("+")) return after + before;
        else if (operand.equals("-")) return after - before;
        else if (operand.equals("*")) return after * before;
        else return after / before;
    }
}
