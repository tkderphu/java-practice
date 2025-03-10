package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <n ;j++) {
                int x = input.nextInt();
                if(x == 1) {
                    list.add(j);
                }
            }
            lists.add(list);
        }
        int[] list = new int[n];
        list[0] = k - 1;
        boolean[] isVisited = new boolean[n];
        isVisited[k - 1] = true;
        hamilton(k - 1,list, lists,n , isVisited,k - 1, k - 1);

    }

    private static void hamilton(int k, int[] list,
                                 List<List<Integer>> lists, int n,
                                 boolean[] isVisited, int vo, int u) {
        for(int i = 0; i < lists.get(u).size(); i++) {
            if(k == n - 1 && lists.get(u).get(i) == vo) {
                for(int j = 0;j < n; j++) {
                    System.out.print((list[j] + 1) + " ");
                }
                System.out.println(vo + 1);
            } else if(!isVisited[lists.get(u).get(i)]) {
                list[k + 1] = lists.get(u).get(i);
                isVisited[lists.get(u).get(i)] = true;
                hamilton(k + 1, list, lists, n, isVisited, vo, lists.get(u).get(i));
                isVisited[lists.get(u).get(i)] = false;
            }
        }
    }

}

