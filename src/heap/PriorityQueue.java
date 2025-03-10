package heap;

import java.lang.reflect.Array;

public class PriorityQueue<T extends Comparable<T>> {

    private Node<T>[] data;
    private int currentSize;
    private final int MAX_SIZE;
    public PriorityQueue(Class<Node> t, int capacity) {
        MAX_SIZE = capacity;
        data = (Node<T>[]) Array.newInstance(t, capacity);
        currentSize = 0;
    }
    static class Node<T> {
        private T value;
        private int priority;
        public Node(T value, int priority) {
            this.value =  value;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }
    }
    public boolean add(T t, int priority) {
        if(!isFull()) {
            data[currentSize] = new Node<>(t, priority);
            siftUp(currentSize);
            currentSize++;
            return true;
        }
        return false;
    }
    public Node<T> remove() {
        if(!isEmpty()) {
            Node<T> value = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize] = null;
            currentSize--;
            siftDown(0);
            return value;
        }
        return null;
    }
    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }
    public boolean isFull() {
        return currentSize == MAX_SIZE ? true : false;
    }
    public void showElement() {
        for(int i =0; i< currentSize; i++) {
            Node<T> node = data[i];
            System.out.println(node.value + "(" + node.priority + ")");

        }
    }

    private void siftDown(int start) {
        int parent = start;
        int childLeft = parent * 2 + 1;
        int childRight = parent * 2 + 1;
        if(childLeft < currentSize && data[childLeft].priority > data[parent].priority) {
            parent = childLeft;
        }
        if(childRight < currentSize && data[childRight].priority > data[parent].priority) {
            parent = childRight;
        }
        if(parent != start) {
            Node<T> value = data[parent];
            data[parent] = data[start];
            data[start] = value;
            siftDown(parent);
        }
    }

    private void siftUp(int currentSize) {
        int child = currentSize;
        int parent = (child - 1) / 2;
        if(parent >= 0 && data[child].priority > data[parent].priority) {
            Node<T> value = data[parent];
            data[parent] = data[child];
            data[child] = value;
            siftUp(parent);
        }
    }
}
