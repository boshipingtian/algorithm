package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(1))));
        ListNode listNode = addTwoNumbers(l1, l2);
        listNode.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int n = (i1 + i2 + carry) % 10;
            carry = (i1 + i2 + carry) / 10;
            if (head == null) {
                head = tail = new ListNode(n);
            } else {
                tail.next = new ListNode(n);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
