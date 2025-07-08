package io.archie.datastruct

import io.archie.algorithm.helper.ListNode
import java.util.LinkedList


/**
 * # 队列
 * 队列是一种遵循先入先出的线性数据结构（FIFO）
 *
 *
 */
class Day02Queue {

    /**
     * Kotlin 队列
     */
    fun kotlinQueue() {
        val queue = LinkedList<Int>()
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        val poll = queue.poll()
        println(poll)
        println(queue)
    }

    /**
     * # 基于链表的队列
     *
     * 定义一个头节点、一个尾节点，规定头节点只能删除元素，尾节点只能添加元素
     */
    class LinkedQueue(
        private var head: ListNode? = null,
        private var tail: ListNode? = null,
        private var size: Int = 0
    ) {

        fun size(): Int {
            return size
        }

        fun isEmpty(): Boolean {
            return size == 0
        }

        fun offer(value: Int) {
            val node = ListNode(value)
            // 如果头节点为空，则令头节点和尾节点都指向该节点
            if (head == null) {
                head = node
                tail = node
            } else {
                // 如果头节点不为空，则将该节点添加到尾节点后
                tail?.next = node
                tail = node
            }
            size++
        }

        fun poll(): Int? {
            val value = peek()
            head = head?.next
            size--
            return value
        }

        fun peek(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return head?.`val`
        }

        fun toArray(): IntArray {
            var node = head
            val res = IntArray(size())
            for (i in res.indices) {
                res[i] = node!!.`val`
                node = node.next
            }
            return res
        }
    }

    /**
     * # 基于数组的队列
     *
     * 在数组中删除一个元素的时间复杂度为O(n)，为了避开这一问题：
     * - 使用变量head记录头节点索引，使用size记录队列长度，使用tail = front+size计算队尾下一个位置的索引
     * - 入队：将输入元素赋值给tail，并将size+1，出队：将head+1，并将size-1
     * - 在不断的入队出队过程中，head和tail都向右移动，达到数组尾部无法继续移动
     * - 为了解决此问题，可以将数组视为首位相接的环形数组，在head和tail越过尾部时，通过取余操作回到数组头部继续
     */
    class ArrayQueue(capacity: Int) {
        private val queue = IntArray(capacity)
        private var head: Int = 0;
        private var size: Int = 0;

        fun capacity(): Int {
            return queue.size
        }

        fun size(): Int {
            return size
        }

        fun isEmpty(): Boolean {
            return size() <= 0
        }

        fun offer(value: Int) {
            if (size() == capacity()) throw RuntimeException("Full queue")
            // 计算队尾索引，等于队尾索引+1
            val tail = (head + size()) % capacity()
            queue[tail] = value
            size++
        }

        fun poll(): Int? {
            val value = peek()
            // 队首指针向后移动1位，如果越过头部，则返回到数组头部
            head = (head + 1) % capacity()
            size--
            return value
        }

        fun peek(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return queue[head]
        }

        fun toArray(): IntArray {
            val res = IntArray(size())
            var i = 0
            var j = head
            while (i < size()) {
                res[i] = queue[j % capacity()]
                i++
                j++
            }
            return res
        }
    }
}