package stack;

import java.lang.reflect.Array;

public class Stack<T> {
    private int capacity;
    private int size;
    private T[] data;
    public Stack(Class<T> tClass) {
        capacity = 10;
        size = 0;
        data = (T[]) Array.newInstance(tClass, capacity);
    }
    public Stack(Class<T> tClass, int capacity) {
        this.capacity = capacity;
        size = 0;
        data = (T[]) Array.newInstance(tClass, capacity);
    }
    public boolean push(T value) {
        if(!isFull()) {
            data[size++] = value;
            return true;
        }
        return false;
    }
    public T pop() {
        T value = data[size - 1];
        size --;
        return value;
    }
    public T peek() {
        return data[size - 1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
