package io.archie.datastruct

import io.archie.algorithm.helper.ListNode
import org.junit.Assert.*
import org.junit.Test

class Day01LinkedListTest {

    val node = ListNode(1, ListNode(3, ListNode(2, ListNode(5, ListNode(4, null)))))

    val linkedListTest = Day01LinkedList()

    @Test
    fun insert() {
        linkedListTest.insert(node, ListNode(0))
        node.print()
    }

    @Test
    fun delete() {
        linkedListTest.delete(node)
        node.print()
    }

    @Test
    fun access() {
        val access = linkedListTest.access(node, 2)
        println(access?.`val`)
    }

    @Test
    fun find() {
        val find = linkedListTest.find(node, 4)
        println(find)
    }

}