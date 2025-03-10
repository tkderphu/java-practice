package heap;

import java.lang.reflect.Array;

public class MaxHeap<E extends Comparable<E>>  {
    private int currentSize;
    private E[] data;
    private int MAX_SIZE;
    public MaxHeap(Class<E> t, int capacity) {
        currentSize = 0;
        MAX_SIZE = capacity;
        data = (E[]) Array.newInstance(t, capacity);
    }

    public boolean add(E e) {
        if(!isFull()) {
            data[currentSize] = e;
            siftUp(currentSize);
            currentSize ++;
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if(!isEmpty()) {
            E valueLastOfArray = data[currentSize - 1];
            data[index] = valueLastOfArray;
            data[currentSize - 1] = null;
            siftDown(index);
            currentSize--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }
    public boolean isFull() {
        return currentSize == MAX_SIZE ? true : false;
    }

    private void siftDown(int index) {
        int parent = index;
        int childLeft = parent * 2 + 1;
        int childRight = parent * 2 + 2;
        if(childLeft < currentSize && data[childLeft].compareTo(data[parent]) > 0) {
            parent = childLeft;
        }
        if(childRight < currentSize && data[childRight].compareTo(data[parent]) > 0) {
            parent = childRight;
        }
        if(parent != index) {
            E tmp = data[index];
            data[index] = data[parent];
            data[parent] = tmp;
            siftDown(parent);
        }

    }


    public void show() {
        System.out.println("-------------------------------");
        for(int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("-------------------------------");
    }


    public E maxValue() {
        return data[0];
    }
    public int size() {
        return currentSize;
    }

    private void siftUp(int currentSize) {
        int child = currentSize;
        int parent = (child - 1) / 2;
        while(parent >= 0 && data[child].compareTo(data[parent]) > 0) {
            E e = data[parent];
            data[parent] = data[child];
            data[child] = e;
            child = parent;
            parent = (child - 1) /2;
        }
    }
}
