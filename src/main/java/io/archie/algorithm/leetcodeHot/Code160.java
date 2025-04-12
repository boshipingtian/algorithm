package io.archie.algorithm.leetcodeHot;

import io.archie.algorithm.helper.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 20:30
 */
public class Code160 {

    /**
     * hash方式，先遍历完一个，把节点都保存到hash中
     * 遍历另一个，直到遍历到hash中首个存在的节点，即为相同节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> sets = new HashSet<>();
        ListNode tempNodeA = headA;
        while (tempNodeA != null) {
            sets.add(tempNodeA);
            tempNodeA = tempNodeA.next;
        }
        ListNode tempNodeB = headB;
        while (tempNodeB!=null){
            if(sets.contains(tempNodeB)){
                return tempNodeB;
            }
            tempNodeB = tempNodeB.next;
        }
        return null;
    }



    public static void main(String[] args) {
        Code160 code160 = new Code160();
        ListNode common = new ListNode(3, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(1, new ListNode(2, common));
        ListNode headB = new ListNode(-1, new ListNode(-2, new ListNode(-3, common)));
        ListNode ans1 = code160.getIntersectionNode(headA, headB);
        System.out.println("ans1 = " + ans1);
    }
}