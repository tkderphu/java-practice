package linkedlist.simple;

public class LinkedList <T>{
    private Node head;
    private Node tail;
    static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public void addHead(T data) {
        if(head == null) {
            tail = head = new Node(data);
        } else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }
    public void addTail(T data) {
        if(tail == null) {
            head = tail = new Node(data);
//            head = tail;
        } else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
    }

    public void addAfterValueX(T x, T data) {
        Node nodeX = head;
        Node p = new Node(data);
        while(nodeX.next != null) {
            if(nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        p.next = nodeX.next;
        nodeX.next = p;
    }

    public void getData() {
        for(Node i = head; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }

    public Node getHead() {
        return head;
    }
}
