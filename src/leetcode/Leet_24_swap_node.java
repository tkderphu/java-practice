package leetcode;

public class Leet_24_swap_node {
}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);

        ListNode pre = dummy;
        ListNode l = head;
        ListNode r = l.next;

        while(true) {
            ListNode rNext = r.next;
            pre.next = r;
            l.next = rNext;
            r.next = l;

            if(rNext == null) break;

            pre = l;
            l = rNext;
            r = l.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
}