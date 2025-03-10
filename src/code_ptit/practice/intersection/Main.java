package code_ptit.practice.intersection;

import java.util.Scanner;
import java.util.Set;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m = sc.nextInt();
        IntSet setA = new IntSet();
        IntSet setB = new IntSet();
        input(setA, n, sc);
        input(setB, m, sc);

        IntSet uni = setA.intersection(setB);
        IntSet interAB = setA.sub(setB);
        IntSet interBa = setB.sub(setA);
        System.out.println(uni);
        System.out.println(interAB);
        System.out.println(interBa);
    }

    public static void input(IntSet set, int n, Scanner input) {
        for(int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }
    }
}
