package leetcode;


import java.util.Stack;

public class Leet_19_remo_nth_node_from_end_of_list {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        Stack<ListNode> st = new Stack<>();

        ListNode pointer = head;
        while(pointer != null) {
            st.push(pointer);
            pointer = pointer.next;
        }

        while(n != 1) {
            n--;
            st.pop();
        }
        ListNode replaceNode = st.pop();
        if(st.empty()) {
            return head.next;
        }
        ListNode before = st.pop();

        before.next = replaceNode.next;

        return head;
    }

}
