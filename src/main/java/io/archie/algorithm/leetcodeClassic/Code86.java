package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分隔链表
 */
public class Code86 {

    public static void main(String[] args) {
        Code86 code86 = new Code86();
        // 1,4,3,2,5,2 x=3
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        head.print();
        ListNode answer = code86.partitionBetter(head, 3);
        answer.print();

        // 1,3,2
        head = new ListNode(1, new ListNode(3, new ListNode(2)));
        head.print();
        answer = code86.partitionBetter(head, 3);
        answer.print();
    }

    /**
     * 我的思路：1. 分割节点，把小于x的节点切开，形成小于的，大于等于的这些节点
     * <p>
     * 2. 拼接节点，循环2次，先循环比x小的，再循环比x大的
     */
    public ListNode partition(ListNode head, int x) {
        List<ListNode> sList = new ArrayList<>();
        List<ListNode> bList = new ArrayList<>();

        ListNode tempNode = head;
        while (tempNode != null) {
            ListNode virtualNode = tempNode;
            if (tempNode.val < x) {
                sList.add(tempNode);
                while (virtualNode != null && virtualNode.val < x) {
                    if (virtualNode.next != null && virtualNode.next.val >= x) {
                        break;
                    }
                    virtualNode = virtualNode.next;
                }
                // 切割
                if (virtualNode != null) {
                    ListNode next = virtualNode.next;
                    virtualNode.next = null;
                    tempNode = next;
                } else {
                    tempNode = null;
                }
            } else {
                bList.add(tempNode);
                while (virtualNode != null && virtualNode.val >= x) {
                    if (virtualNode.next != null && virtualNode.next.val < x) {
                        break;
                    }
                    virtualNode = virtualNode.next;
                }
                // 切割
                if (virtualNode != null) {
                    ListNode next = virtualNode.next;
                    virtualNode.next = null;
                    tempNode = next;
                } else {
                    tempNode = null;
                }
            }
        }

        // 拼接
        // 1. 循环第一次 找小于x的
        ListNode dummyNode = new ListNode(-1);
        ListNode tempNodeA = dummyNode;
        for (ListNode s : sList) {
            tempNodeA.next = s;
            while (s.next != null) {
                s = s.next;
            }
            tempNodeA = s;
        }
        // 2. 循环第二次 找大于x的
        for (ListNode b : bList) {
            tempNodeA.next = b;
            while (b.next != null) {
                b = b.next;
            }
            tempNodeA = b;
        }
        return dummyNode.next;
    }

    /**
     * 更好的分组方法，建立两个新链表，sml，big。遍历一次原始链表，往新链表里添加。最后让sml->big->null即可
     */
    public ListNode partitionBetter(ListNode head, int x) {
        ListNode sml = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode smlStartNode = sml;
        ListNode bigStartNode = big;
        while (head != null) {
            if (head.val < x) {
                sml.next = new ListNode(head.val);
                sml = sml.next;
            }else {
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        sml.next = bigStartNode.next;
        return smlStartNode.next;
    }
}
