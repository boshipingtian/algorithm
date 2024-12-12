package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

import java.util.Stack;

public class Code19 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head1.print();
        ListNode head2 = new ListNode(1);
        head2.print();
        ListNode head3 = new ListNode(1, new ListNode(2));
        head3.print();
        Code19 code19 = new Code19();
        // 我自己的写法
        // ListNode answer1 = code19.removeNthFromEndSelf(head1, 2);
        // answer1.print();
        // ListNode answer2 = code19.removeNthFromEndSelf(head2, 1);
        // answer2.print();
        // ListNode answer3 = code19.removeNthFromEndSelf(head3, 2);
        // answer3.print();

        // 获取长度的常规写法
        // ListNode answer1 = code19.removeNthFromEndStd(head1, 2);
        // answer1.print();
        // ListNode answer2 = code19.removeNthFromEndStd(head2, 1);
        // answer2.print();

        // 使用栈的方式的写法
        // ListNode answer1 = code19.removeNthFromEndStack(head1, 2);
        // answer1.print();
        // ListNode answer2 = code19.removeNthFromEndStack(head2, 1);
        // answer2.print();

        // 使用双指针的写法
        ListNode answer1 = code19.removeNthFromEndDoublePointer(head1, 2);
        answer1.print();
        ListNode answer2 = code19.removeNthFromEndDoublePointer(head2, 1);
        answer2.print();
    }

    /**
     * 我自己的想法，时间复杂度是O(mn)，空间复杂度是O(n)
     * <p>
     * 实际的想法还是类似双指针，定义了两个变量，一个是确定目标节点，另一个得到目标节点的前一个节点
     *
     * @param head 头节点
     * @param n    要删除的倒数节点
     * @return {@link ListNode }
     */
    public ListNode removeNthFromEndSelf(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 使用虚拟节点，防止头节点丢失
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        // -1,1,2
        // 1
        // 遍历到指定的倒数第n个节点之前停住。
        // 然后获取倒数第n-1和第n+1个节点
        // 把n-1节点的next指向n+1节点

        // left 比 right 多一个节点，如果left符合第n个节点，right就是第n-1个节点
        ListNode left = virtualNode.next;
        ListNode right = virtualNode;
        while (left != null) {
            ListNode prev = left;
            for (int i = 0; i < n; i++) {
                prev = prev.next;
            }
            // 如果prev是null，那么就是right第n-1个节点
            if (prev == null) {
                right.next = right.next.next;
                break;
            }
            left = left.next;
            right = right.next;
        }

        return virtualNode.next;
    }

    /**
     * 获取长度的写法，常规写法
     * <p>
     * 时间复杂度O(2N)，空间复杂度O(N)，使用常数空间
     *
     * @param head 头节点
     * @param n    要删除的倒数节点
     * @return {@link ListNode }
     */
    public ListNode removeNthFromEndStd(ListNode head, int n) {
        // 依旧需要一个虚拟节点，因为头也可能被删除。

        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        // 1. 获取链表长度
        int length = 0;
        ListNode dummyNode = virtualNode;
        while (dummyNode != null) {
            dummyNode = dummyNode.next;
            length++;
        }
        // 2. 计算出正数节点数M
        int m = length - n;
        dummyNode = virtualNode;
        for (int i = 0; i < m - 1; i++) {
            if (dummyNode != null) {
                dummyNode = dummyNode.next;
            }
        }
        // 3. 把遍历到M-1，把M-1指向M+1
        if (dummyNode != null && dummyNode.next != null) {
            dummyNode.next = dummyNode.next.next;
        }
        return virtualNode.next;
    }

    /**
     * 使用栈方式完成
     * <p>
     * 因为是倒数节点，所以很容易想到栈这种先入后出的性质
     * <p>
     * 我们只需要把链表依次入栈，然后n-1个出栈的就是后一个节点，n+1个出栈的就是前一个节点，
     * 记录一下然后连接重新连接这两个就行了
     *
     * @param head 头节点
     * @param n    要删除的倒数节点
     * @return {@link ListNode }
     */
    public ListNode removeNthFromEndStack(ListNode head, int n) {
        // 需要假节点，因为可能会删除第一个节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode tempNode = dummyNode;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.next;
        }

        // 弹出到n-1个，记录一下
        ListNode curr = null;
        // 弹出到n+1个，记录一下
        ListNode prev = null;

        for (int i = 0; i < n + 1; i++) {
            ListNode pop = stack.pop();
            if (i == n - 2) {
                curr = pop;
            } else if (i == n) {
                prev = pop;
                break;
            }
        }
        if (prev != null) {
            prev.next = curr;
        }
        return dummyNode.next;
    }


    /**
     * 双指针写法，和第一种我想的类似，但是这个更好一点
     * <p>
     * 定义两个节点，作为左右节点指针，因为要删除倒数第n个数据，
     * 所以我们让左右指针相距n，当右节点走到头时（right == null），左节点就是要删除的节点，
     * 所以就是right.next == null，left.next = left.next.next;
     * 1，2，3
     *
     * @param head 头
     * @param n    n
     * @return {@link ListNode }
     */
    public ListNode removeNthFromEndDoublePointer(ListNode head, int n) {
        // 假节点
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        // -1,1,2,3,4,5

        ListNode tempNode = virtualNode;
        ListNode left = tempNode;
        ListNode right = tempNode;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return virtualNode.next;
    }
}
