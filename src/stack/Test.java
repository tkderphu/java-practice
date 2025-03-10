package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void threeWayPartition(int array[], int a, int b)
    {
        List<Integer> list = new ArrayList<>();
        swap(list, array, -1, a);
        swap(list, array, a, b);
        swap(list, array, b, -1);
        for(int i =0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    private static void swap(List<Integer> list, int[] array, int x, int y) {
        for(int i = 0; i < array.length; i++) {
            if(x == -1) {
                if(array[i] <= y) {
                    list.add(array[i]);
                }
            } else if(y == -1) {
                if(array[i] > x) {
                    list.add(array[i]);
                }
            } else {
                if(array[i] > x && array[i] <= y) {
                    list.add(array[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {6 ,22 ,68, 5 ,14, 62, 55, 27, 60, 45, 3, 3, 7, 85};
        threeWayPartition(a, 22, 64);
    }
}



