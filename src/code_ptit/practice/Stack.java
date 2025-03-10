package code_ptit.practice;


import java.util.LinkedList;
import java.util.List;

public class Stack<T> {
    private LinkedList<T> linkedList;
    public Stack() {
        this.linkedList = new LinkedList<>();
    }

    public void push(T t) {
        linkedList.push(t);
    }

    public T pop() {
        return linkedList.pop();
    }
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
