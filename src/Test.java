import org.w3c.dom.Node;

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int x, ListNode next) {
        val = x;
       this.next = next;
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        var node = head;
        ListNode prev = null;
        while(node != null) {
            if(map.containsKey(node.val)) {
                ListNode prevCurrentNode = map.get(node.val);
                if(prevCurrentNode == null) {
                    head = head.next;
                    node = head;
                } else {
                    prevCurrentNode.next = node.next;
                    node = node.next;
                }
                prev = prevCurrentNode;
            } else {
                map.put(node.val, prev);
                prev = node;
                node = node.next;
            }
        }
        return head;
    }
}

public class Test {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(1, new ListNode(2, new ListNode(2))));
        new Solution().deleteDuplicates(listNode);
    }
}
