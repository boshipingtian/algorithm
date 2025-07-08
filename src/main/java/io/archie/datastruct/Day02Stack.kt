package io.archie.datastruct

import io.archie.algorithm.helper.ListNode
import java.util.Stack


/**
 * # 栈
 * 栈是一种遵循先入后出的线性数据结构（FILO）
 *
 * ## 典型应用
 * - 浏览器前进后退，软件的撤销与反撤销
 * - 程序内存管理
 */
class Day02Stack {

    /**
     * 基于kotlin的栈
     */
    fun kotlinStack() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(3)
        stack.push(2)
        stack.push(5)
        stack.push(4)
        // 打印原始数据
        println(stack)
        // 访问栈顶元素
        val top = stack.peek()
        println(top)
        // 元素出栈
        val pop = stack.pop()
        println(pop)
        // 栈长度
        val size = stack.size
        println(size)
        // 是否为空
        val isEmpty = stack.isEmpty()
        println(isEmpty)
    }

    /**
     * # 基于链表实现栈
     *
     * - 时间效率
     * 链表的扩容非常灵活，不存在数组扩容时效率降低的问题，但是入栈操作需要初始化节点并修改指针，因此效率较低
     * 基于链表的栈可以提供更稳定的效率表现
     *
     * - 空间效率
     * 链表节点需要额外存储指针，链表节点占用的空间相对较大
     */
    class LinkedListStack(
        private var stackPeek: ListNode? = null,
        private var stackSize: Int = 0
    ) {

        fun size(): Int {
            return stackSize
        }

        fun isEmpty(): Boolean {
            return size() == 0
        }

        /**
         * 入栈
         */
        fun push(value: Int) {
            val newHead = ListNode(value)
            newHead.next = stackPeek
            stackPeek = newHead
            stackSize++
        }

        /**
         * 出栈
         */
        fun pop(): Int? {
            val num = peek()
            stackPeek = stackPeek?.next
            stackSize--
            return num
        }

        /**
         * 访问栈顶元素
         */
        fun peek(): Int? {
            if (isEmpty()) {
                throw IndexOutOfBoundsException()
            }
            return stackPeek?.`val`
        }

        /**
         * 转成Array返回
         */
        fun toArray(): IntArray {
            var node = stackPeek
            val res = IntArray(size())
            for (i in size() - 1 downTo 0) {
                res[i] = node?.`val`!!
                node = node.next
            }
            return res
        }
    }

    /**
     * # 基于数组的栈
     *
     * - 时间效率
     * 基于数组的实现，入栈和出栈都在预先分配号的连续内存中进行，具有很好的缓存本地性，因此效率较高。
     * 如果入栈触发扩容操作，时间复杂度变为O(n)
     *
     * - 空间效率
     * 初始化列表时，系统会为列表分配初始容量，并且扩容时也是按照特定倍率扩容，可能造成一定的空间浪费
     */
    class ArrayStack {

        private val stack = mutableListOf<Int>()

        fun size(): Int {
            return stack.size
        }

        fun isEmpty(): Boolean {
            return size() <= 0
        }

        /**
         * 入栈
         */
        fun push(value: Int) {
            stack.add(value)
        }

        /**
         * 出栈
         */
        fun pop(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return stack.removeAt(size() - 1)
        }

        /**
         * 访问栈顶元素
         */
        fun peek(): Int? {
            if (isEmpty()) throw IndexOutOfBoundsException()
            return stack[size() - 1]
        }

        /**
         * 转换为Array返回
         */
        fun toArray(): Array<Any> {
            return stack.toTypedArray()
        }

    }


}