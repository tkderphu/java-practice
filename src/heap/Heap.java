package heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap {
    long data[];
    int currentSize;
    int MAX_SIZE;
    public Heap(int n) {
        data = new long[n];
        currentSize = 0;
        MAX_SIZE = n;
    }
    public void add(long value) {
        data[currentSize] = value;
        siftUp(currentSize);
        currentSize++;
    }
    public long remove() {
        if(!isEmpty()) {
            long value = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize - 1] = 0;
            currentSize--;
            siftDown(0);
            return value;
        }
        return -1;
    }
    public void siftDown(int start) {
        int parent = start;
        int child1 = parent * 2 + 1;
        int child2 = parent * 2 + 2;
        if(child2 < currentSize && data[child2] < data[parent]) {
            parent = child2;
        }
        if(child1 < currentSize && data[child1] < data[parent]) {
            parent = child1;
        }
        if(parent != start) {
            long tmp = data[parent];
            data[parent] = data[start];
            data[start] = tmp;
            siftDown(parent);
        }
    }
    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }
    public void siftUp(int index) {
        int child = index;
        int parent = (child - 1) / 2;
        if(parent >= 0 && data[child] < data[parent]) {
            long tmp = data[parent];
            data[parent] = data[child];
            data[child] = tmp;
            siftUp(parent);
        }
    }

    ArrayList<Integer> TopK(ArrayList<Integer> array, int k)
    {
        java.util.PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> {
                    if(e1.getValue() != e2.getKey()) {
                        return e2.getValue() - e1.getValue();
                    } else {
                        return e2.getKey() - e1.getKey();
                    }
                });
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.size(); i++) {
            if(map.get(array.get(i)) != null) {
                map.put(array.get(i), map.get(array.get(i)) + 1);
            } else {
                map.put(array.get(i), 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(k--> 0) {
            list.add(priorityQueue.remove().getKey());
        }
        return list;

    }

    public static void main(String[] args) {
        long arr[] = {4 ,3 ,2 ,6};

    }
}