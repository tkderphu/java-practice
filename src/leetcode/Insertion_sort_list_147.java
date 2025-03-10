package leetcode;


import java.util.List;
import java.util.Stack;

public class Insertion_sort_list_147 {
      static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode insertionSortList(ListNode head) {
        ListNode next = head.next;
        while(next != null) {
            ListNode post = head;
            while(next.val >= post.val) {
                post = post.next;
            }
            ListNode p = next.next;
            next.next = post;
            post.next = p;

            head = next;
            next = p;
        }
        return head;

        //hehe
    }

    public static void main(String[] args) {
        new Insertion_sort_list_147().insertionSortList(new ListNode(4,
                new ListNode(2, new ListNode(1,
                        new ListNode(3, null)))));
    }
}
