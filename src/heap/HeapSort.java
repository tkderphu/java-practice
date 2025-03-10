package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HeapSort {
    public static <E> void sort(Comparator<E>  comparator, E[] array) {
        int n = array.length;
        for(int i = n/2 - 1; i >= 0; i--) {
            siftDown(comparator,array, i, n);
        }
        for(int i = n - 1; i > 0; i--) {
            E tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            siftDown(comparator, array, 0, i);
        }
    }

    private static <E> void siftDown(Comparator<E> comparator,
                                                           E[] array, int i, int n) {
        int parent = i;
        int childLeft = i * 2 + 1;
        int childRight = i * 2 + 2;
        if(childLeft < n && comparator.compare(array[childLeft], array[parent]) > 0) {
            parent = childLeft;
        }
        if(childRight < n && comparator.compare(array[childRight], array[parent]) > 0 ) {
            parent = childRight;
        }
        if(parent != i) {
            E tmp = array[parent];
            array[parent] = array[i];
            array[i] = tmp;
            siftDown(comparator, array, parent, n);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s1 = input.nextLine();
        String s2 = input.nextLine();
        String words1[] = s1.split("\\s+");
        String words2[] = s2.split("\\s+");
        check(words1, words2);
    }

    private static void check(String[] a1, String[] a2) {
        int i = 0;
        while(i < a1.length) {
            if(a1[i].compareTo(a2[i]) != 0) {
                System.out.println("Index: " + i);
                System.out.printf("Pair value (a1, a2) = (%s, %s)", a1[i], a2[i]);
                System.out.println();
            }
            i++;
        }
    }

    private static <E> int sortHeap(Comparator<E> o, E e1, E e2) {
        return o.compare(e1, e2);
    }
}
