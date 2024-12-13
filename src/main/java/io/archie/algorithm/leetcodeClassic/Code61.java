package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

/**
 * 旋转链表
 */
public class Code61 {

    public static void main(String[] args) {
        Code61 code61 = new Code61();
        // 1,2,3,4,5
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head.print();
        ListNode answer1 = code61.rotateRight(head, 2);
        answer1.print();

        // 0,1,2
        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        head1.print();
        ListNode answer2 = code61.rotateRight(head1, 4);
        answer2.print();
    }

    /**
     * 我的思路：循环k次，每次保存head，遍历到n-1个，然后把n指向head，n-1指向null
     *
     * 出现超时问题，k过大；通过分析，当旋转链表长度m次时，和原来链表一样，所以我们让k对链表长度取模，就可以在最多m次循环完成旋转。
     *
     * 时间复杂度是O(mn)，空间复杂度为O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode loopHead = head;
        while (loopHead != null) {
            loopHead = loopHead.next;
            length++;
        }
        k = k % length;

        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            ListNode curr = newHead;
            while (curr.next != null && curr.next.next != null) {
                curr = curr.next;
            }
            if (curr.next != null) {
                ListNode temp = curr.next;
                curr.next.next = newHead;
                newHead = temp;
                curr.next = null;
            }
        }
        return newHead;
    }
}
