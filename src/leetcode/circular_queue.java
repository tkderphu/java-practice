package leetcode;

public class circular_queue {
    static class LinkList {
        Node head;
        Node tail;

        public void insert(int val) {
            if(head == null) {
                head = tail = new Node(val);
            } else {
                tail.next = new Node(val);
                tail.next.prev = head;
                tail  = tail.next;
            }
        }

        public void deleteLast() {
            if(tail == head) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }
    static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }


    static class MyCircularQueue {
        int size;
        int capacity;
        LinkList queue;
        public MyCircularQueue(int k) {
            this.size = 0;
            this.capacity = k;
            this.queue = new LinkList();
        }

        public boolean enQueue(int value) {
            if(size < capacity) {
                this.queue.insert(value);
                size += 1;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if(size == 0) {
                return false;
            } else {
                this.queue.deleteLast();
                size -= 1;
            }
            return true;
        }

        public int Front() {
            if(this.queue.head == null) {
                return -1;
            }
            return this.queue.head.val;
        }

        public int Rear() {
            if(this.queue.tail == null) {
                return -1;
            }
            return this.queue.tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(9);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(0);

        myCircularQueue.deQueue();
        myCircularQueue.deQueue();

        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
    }
}
