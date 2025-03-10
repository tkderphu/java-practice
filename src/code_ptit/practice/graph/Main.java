package code_ptit.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int x = sc.nextInt();
                if(x == 1 && i < j) {
                    list.add(new Pair<>(i, j));
                }
            }
        }
        for(Pair<Integer, Integer> pair : list) {
            System.out.println(pair);
        }
    }
}
