package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code83 {

    public static void main(String[] args) {
        Code83 code83 = new Code83();
        // 1,2,3,3,4,4,5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        head1.print();
        ListNode answer1 = code83.deleteDuplicatesSelf(head1);
        answer1.print();
        // 1,1
        ListNode head2 = new ListNode(1, new ListNode(1));
        head2.print();
        ListNode answer2 = code83.deleteDuplicatesSelf(head2);
        answer2.print();
    }


    /**
     * 删除已排序链表的重复数据
     * <p>
     * 我自己的想法是双指针，right向前移动
     * <p>
     * 1. if left != right; left++,right++;
     * 2. if left == right, right++; until left != right; left.next = right
     *
     * @param head 头
     * @return {@link ListNode }
     */
    public ListNode deleteDuplicatesSelf(ListNode head) {
        // 1个
        if (head == null || head.next == null) {
            return head;
        }
        // 2个及以上
        ListNode left = head; //-1,1
        ListNode right = head.next; //1
        while (right != null && left != null) {
            if (left.val != right.val) {
                left = left.next;
                right = right.next;
            } else {
                while (right != null && left.val == right.val) {
                    right = right.next;
                }
                left.next = right;
            }
        }
        return head;
    }
}
