package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class populating_next_right_pointers_in_each_node_ii {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * My solution => ....
     * @param root
     * @return
     */
//    public Node connect(Node root) {
//        if(root == null) return null;
//        Queue<Node> q1 = new LinkedList<>();
//        q1.add(root);
//        while(q1.size() > 0) {
//            Queue<Node> q2 = new LinkedList<>(q1);
//            while(q2.size() > 0) {
//                Node first = q2.remove();
//                if(q2.size() > 0) {
//                    first.next = q2.element();
//                }
//                q1.remove();
//                if(first.left != null) {
//                    q1.add(first.left);
//                }
//                if(first.right != null) {
//                    q1.add(first.right);
//                }
//            }
//        }
//        return root;
//    }


    public void connect(Node root) {
        Node dummyhead = new Node(0);
        Node current = null;
        while (root != null) {
            current = dummyhead;
            while (root != null) {
                if (root.left != null) { current.next = root.left; current = current.next; }
                if (root.right != null) { current.next = root.right; current = current.next; }
                root = root.next;
            }
            root = dummyhead.next;
            dummyhead.next = null;
        }
    }
}
