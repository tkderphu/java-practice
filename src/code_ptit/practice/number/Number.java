package code_ptit.practice.number;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        IntSet intSet = new IntSet("TRUYVAN.in");
        System.out.println(intSet.min());
        System.out.println(intSet.max());
        System.out.println(intSet.sum());
    }
}
