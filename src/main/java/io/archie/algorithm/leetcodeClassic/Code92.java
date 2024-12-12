package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head.print();
        Code92 code92 = new Code92();
        ListNode listNode = code92.reverseBetween(head, 2, 4);
        listNode.print();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        // 使用虚拟头节点，防止开始节点需要反转的情况
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;

        // 第一步，拆分出第一段，遍历到left-1节点
        ListNode prev = virtualHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 第二步， 拆分出需要反转的一段，从上一个开始节点遍历 right-left+1处为反转链表的最后一个节点
        ListNode endNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            endNode = endNode.next;
        }

        //第三步，切割出需要反转的链表，同时保留最后连接时需要的开始节点和结束节点
        ListNode curr = endNode.next;
        ListNode startNode = prev.next;

        //第四步，截断
        prev.next = null;
        endNode.next = null;

        // 第五步，反转链表
        reverse(startNode);

        // 第六步，拼接
        prev.next = endNode;
        startNode.next = curr;

        return virtualHead.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
