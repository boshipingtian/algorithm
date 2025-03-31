package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

/**
 * 删除排序链表中的重复元素II
 * <p>
 * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表
 */
public class Code82 {

    public static void main(String[] args) {
        Code82 code82 = new Code82();
        // 1,2,3,3,4,4,5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        head1.print();
        ListNode answer1 = code82.deleteDuplicatesSelf(head1);
        answer1.print();
        // 1,1,1,2,3
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        head2.print();
        ListNode answer2 = code82.deleteDuplicatesSelf(head2);
        answer2.print();
        // 1,1
        ListNode head3 = new ListNode(1, new ListNode(1));
        head3.print();
        ListNode answer3 = code82.deleteDuplicatesSelf(head3);
        try {
            answer3.print();
        } catch (Exception e) {
            System.out.println("[]");
        }

        // -3,-3,-2,-1,-1,0,0,0,0,0
        ListNode head4 = new ListNode(-3, new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0))))))))));
        head4.print();
        ListNode answer4 = code82.deleteDuplicates(head4);
        answer4.print();

        // -1,0,0,0,0,3,3
        ListNode head5 = new ListNode(-1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(3, new ListNode(3)))))));
        head5.print();
        ListNode answer5 = code82.deleteDuplicates(head5);
        answer5.print();
    }


    /**
     * 我的思路是，再原来指针的基础上，增加一个假节点和一个leftPrev。这样当left.val==right.val时，
     * 让left = left.next; right = right.next；直到left.val != right.val；此时让leftPrev.next = right
     * 如果left.val != right.val时，正常让leftPrev,left,right向右位移
     *
     * @param head 头
     * @return {@link ListNode }
     */
    public ListNode deleteDuplicatesSelf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 假节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode leftPrev = dummyNode;
        ListNode left = dummyNode.next;
        ListNode right = dummyNode.next.next;

        while (right != null) {
            if (left.val != right.val) {
                left = left.next;
                right = right.next;
                leftPrev = leftPrev.next;
            } else {
                while (right != null && left.val == right.val) {
                    right = right.next;
                }
                leftPrev.next = right;
                left = right;
                if(right != null){
                    right = right.next;
                }
            }
        }
        return dummyNode.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-999);
        dummyNode.next = head;
        // 判断dummyNode.next 与 dummyNode.next.next的关系，如果相等，就把dummyNode.next和往后相同的数据移除
        ListNode curr = dummyNode;
        int x = -999;
        while (curr != null) {
            if (curr.next != null && curr.next.next != null) {
                // 如果curr的next和next.next的值一样 或者 等于之前重复的x值，就清除curr.next节点为curr.next.next
                if (curr.next.val == curr.next.next.val || curr.next.val == x) {
                    x = curr.next.val;
                    curr.next = curr.next.next;
                } else {
                    // 否则 继续往下递归
                    curr = curr.next;
                }
            } else if (curr.next != null && curr.next.val == x) {
                curr.next = null;
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }

}
