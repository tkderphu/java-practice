//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//class Node {
//    int data;
//    Node next;
//    Node tail;
//    Node head;
//
//    public Node() {
//
//    }
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//
//    void addNode(int a) {
//        if (head == null) {
//            head = tail = new Node(a);
//        } else {
//            Node p = new Node(a);
//            tail.next = p;
//            tail = p;
//        }
//    }
//
//    void addNode(int arr[], int n) {
//        for (int i = 0; i < n; i++) {
//            addNode(arr[i]);
//        }
//    }
//    void addTail(Node node) {
//        tail.next = node;
//        tail = node;
//    }
//}
//
//class Solution {
//
//    public static Node zigZag(Node head) {
//
//    }
//    //This method returns the head node of the reversed Linked list.
//
//    public static void main(String[] args) {
//        Node node = new Node();
//        Scanner scanner = new Scanner(System.in);
//        String data = scanner.nextLine();
//        String[] num = data.split("\\s+");
//        int[] arr = new int[num.length];
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(num[i]);
//        }
//        node.addNode(arr, arr.length);
//        zigZag(node.head);
//    }
//}