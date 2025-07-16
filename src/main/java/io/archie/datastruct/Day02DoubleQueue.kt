package io.archie.datastruct

import io.archie.algorithm.helper.DoubleListNode
import java.util.*

/**
 * # 双向队列
 * 普通队列中，仅能在头部删除元素或在纬度添加元素。双向队列中，既可以在头部添加元素，也可以在尾部添加元素。
 *
 * 双向队列兼具栈与队列的逻辑，因此可以实现这两者所有的应用场景，同时具有更高的自由度
 */
class Day02DoubleQueue {

    fun kotlinDoubleQueue() {
        val deque = LinkedList<Int>()
        // 入队
        deque.offerLast(2) // offerLast()方法在尾部添加元素
        deque.offerLast(5)
        deque.offerLast(4)
        deque.offerFirst(3) // offerFirst()方法在头部添加元素
        deque.offerFirst(1)
        println("deque: $deque")

        // 访问元素
        val peekFirst = deque.peekFirst() // peekFirst()方法返回队列头部的元素，但不删除该元素
        val peekLast = deque.peekLast() // peekLast()方法返回队列尾部的元素，但不删除该元素

        // 元素出队
        val pollFirst = deque.pollFirst() // pollFirst()方法返回队列头部的元素，并删除该元素
        val pollLast = deque.pollLast() // pollLast()方法返回队列尾部的元素，并删除该元素
        println("peekFirst: $peekFirst, peekLast: $peekLast, pollFirst: $pollFirst, pollLast: $pollLast")
        println("deque: $deque")
        // 获取长度
        val size = deque.size // size属性返回队列的长度
        println("size: $size")

        // 判断是否为空
        val isEmpty = deque.isEmpty()
        println("isEmpty: $isEmpty")
    }

    /**
     * ## 基于双向链表实现
     */
    class LinkedListDoubleQueue(
        private var head: DoubleListNode? = null,
        private var tail: DoubleListNode? = null,
        private var size: Int = 0
    ) {

        fun size(): Int {
            return size
        }

        fun isEmpty(): Boolean {
            return size <= 0
        }

        private fun offer(value: Int, isFront: Boolean) {
            val node = DoubleListNode(value)
            if (isEmpty()) {
                head = node
                tail = node
            } else if (isFront) {
                head?.prev = node
                node.next = head
                head = node
            } else {
                tail?.next = node
                node.prev = tail
                tail = node
            }
            size++
        }

        fun offerFirst(value: Int) {
            offer(value, true)
        }

        fun offerLast(value: Int) {
            offer(value, false)
        }

        fun peekFirst(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return head?._val
        }

        fun peekLast(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return tail?._val
        }

        private fun pop(isFront: Boolean): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            var value: Int?
            if (isFront) {
                value = head?._val
                val next = head?.next
                if (next != null) {
                    next.prev = null
                    head?.next = null
                }
                head = next
            } else {
                value = tail?._val
                val prev = tail?.prev
                if (prev != null) {
                    tail?.prev = null
                    prev.next = null
                }
                tail = prev
            }
            size--
            return value
        }

        fun popFirst(): Int? {
            return pop(true)
        }

        fun popLast(): Int? {
            return pop(false)
        }

        fun toArray(): IntArray {
            var node = head
            val res = IntArray(size())
            for (i in res.indices) {
                res[i] = node!!._val
                node = node.next
            }
            return res
        }
    }

    class ArrayDoubleQueue(capacity: Int) {
        private var nums: IntArray = IntArray(capacity)
        private var head: Int = 0
        private var size: Int = 0

        fun capacity(): Int {
            return nums.size
        }

        fun size(): Int {
            return size
        }

        fun isEmpty(): Boolean {
            return size <= 0
        }

        fun index(i: Int): Int {
            // 通过取余实现数组首尾相连
            return (i + capacity()) % capacity()
        }

        fun offerFirst(value: Int) {
            if (size() == capacity()) throw IndexOutOfBoundsException()
            // 队首指针向左移动一位
            // 通过取余从头部回到尾部
            head = index(head - 1)
            // 将value添加到队首
            nums[head] = value
            size++
        }

        fun offerLast(value: Int) {
            if (size() == capacity()) throw IndexOutOfBoundsException()
            // 队尾指针计算
            val tail = index(head + size())
            // 将value添加到队尾
            nums[tail] = value
            size++
        }

        fun popFirst(): Int {
            // 从队首挑出来数据
            val value = peekFirst()
            // 队首指针向右移动一位，使用取余计算索引
            head = index(head + 1)
            size--
            return value
        }

        fun popLast(): Int {
            // 从队尾挑出来数据
            val value = peekLast()
            // 队尾指针向左移一位
            size--
            return value
        }

        fun peekFirst(): Int {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return nums[head]
        }

        fun peekLast(): Int {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return nums[index(head + size() - 1)]
        }

        fun toArray(): IntArray {
            val res = IntArray(size())
            var i = 0
            var j = head
            while (i < size()) {
                res[i] = nums[index(j)]
                i++
                j++
            }
            return res
        }
    }
}