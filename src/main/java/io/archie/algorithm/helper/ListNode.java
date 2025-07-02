package io.archie.algorithm.helper;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/13 15:50
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(){
        ListNode temp = this;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}