package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code141 {

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(-4);
        ListNode listNode0 = new ListNode(0, listNode4);
        ListNode listNode2 = new ListNode(2, listNode0);
        ListNode listNode3 = new ListNode(3, listNode2);
        listNode4.next = listNode2;
        System.out.println(hasCycle(listNode3));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
