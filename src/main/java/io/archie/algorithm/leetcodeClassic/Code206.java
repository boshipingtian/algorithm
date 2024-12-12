package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head.print();
        Code206 code206 = new Code206();
        ListNode listNode = code206.reverseList2(head);
        listNode.print();
    }

    /**
     * 使用循环完成链表反转
     *
     * @param head 头
     * @return {@link ListNode }
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 使用递归完成链表反转
     *
     * @param head 头
     * @return {@link ListNode }
     */
    public ListNode reverseList2(ListNode head) {
        // 1,2,3,4,5
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
