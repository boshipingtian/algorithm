package io.archie.algorithm.leetcode;

import io.archie.algorithm.helper.ListNode;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/13 15:50
 */
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
        ListNode fast = head, slow =head;
        while(true){
            if(fast == null){
                return false;
            }
            fast = fast.next;
            if(fast == null){
                return false;
            }
            if(fast == slow){
                return true;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}