package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.ListNode;

public class Code21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3,new ListNode(4)));
        ListNode result = mergeTwoLists(list1, list2);
        result.print();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        ListNode list1Node = list1;
        ListNode list2Node = list2;
        while (list1Node != null || list2Node != null){
            if(list1Node != null && list2Node != null){
                if(list1Node.val > list2Node.val){
                    temp.next = list2Node;
                    list2Node = list2Node.next;
                }else {
                    temp.next = list1Node;
                    list1Node = list1Node.next;
                }
            }else if(list1Node == null){
                temp.next = list2Node;
                list2Node = list2Node.next;
            }else {
                temp.next = list1Node;
                list1Node = list1Node.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}
