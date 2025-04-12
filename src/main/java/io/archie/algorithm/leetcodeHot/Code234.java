package io.archie.algorithm.leetcodeHot;

import io.archie.algorithm.helper.ListNode;

/**
 * 回文链表<br>
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 21:37
 */
public class Code234 {

    /**
     * 思路：寻找中点，反转链表
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while(pre != null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Code234 code234 = new Code234();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(1)))));

        boolean palindrome = code234.isPalindrome(head1);
        System.out.println("palindrome = " + palindrome);
    }
}