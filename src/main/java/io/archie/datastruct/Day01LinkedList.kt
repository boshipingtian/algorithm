package io.archie.datastruct

import io.archie.algorithm.helper.ListNode

/**
 * 链表
 */
class Day01LinkedList {
    val n0 = ListNode(1, null)
    val n1 = ListNode(3, null)
    val n2 = ListNode(2, null)
    val n3 = ListNode(5, null)
    val n4 = ListNode(4, null)

    init {
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }
}

fun main() {
    val linkedList = Day01LinkedList()
    linkedList.n0.print()
}