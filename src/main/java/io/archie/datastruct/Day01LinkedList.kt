package io.archie.datastruct

import io.archie.algorithm.helper.ListNode

/**
 * # 链表
 *
 * ## 特点
 * - 链表是一种线性的数据结构，其中每个元素都是一个节点对象，各个节点通过引用相连接
 * - 引用记录了下一个节点的内存地址，通过它可以从当前节点访问到下一个节点
 * - 链表的设计使得各个节点可以分散存储在内存各处，内存地址无需连续
 *
 * ## 常见链表类型
 * - 单向链表：即普通链表，包含值和下一个节点的引用，首个节点称为头节点，最后一个节点称为尾节点，单向链表每个节点都认为自己是（头节点）
 * - 环形链表：如果令单向链表尾节点指向头节点，则得到一个环形链表，任意节点都视为头节点
 * - 双向链表：双向链表记录了两个方向的引用。每个节点包含后继节点和前驱节点的引用，相较单向链表更具灵活性，可以超两个方向遍历链表
 *
 * ## 链表的典型应用
 * ### 单向链表
 * - 栈与队列：插入和删除在链表一端进行，表现为先进后出，对应栈；在一端插入，另一端删除，表现为先进先出，对应队列。
 * - 哈希表：链式地址是解决哈希冲出的主流方案之一，所有冲突的元素放到一个链表中。
 * - 图：邻接表是标识图的一种常见方式，其中图的每个点点都与一个链表相关联，链表中每个元素都代表与该顶点相连的其他顶点。
 * ### 双向链表
 * - 高级数据结构：红黑树、B数，保存指向父节点的引用来方便访问。
 * - 浏览器历史：前进后退操作使用双向链表操作更简单。
 * - LRU算法：快速寻找最近最少使用的数据，以及支持快速添加和删除节点。
 * ### 环形链表
 * - 时间片轮转调度算法：操作系统中一种常见的CPU调度算法，需要对一组进程进行循环。每个进程被赋予一个时间片，当时间片用完时，CPU将切换到下一个进程。这种循环操作可以通过环形链表实现。
 * - 数据缓冲区：某些数据缓冲区的实现可能会使用环形链表，比如音频、视频播放器中，数据流分割成多个缓冲块放入环形链表，以便实现无缝播放。
 */
class Day01LinkedList {

    /**
     * 插入节点
     * 在n0后插入p
     */
    fun insert(n0: ListNode?, p: ListNode?) {
        val n1 = n0?.next;
        p?.next = n1
        n0?.next = p
    }

    /**
     * 删除节点
     * 删除n0后的首个节点
     */
    fun delete(n0: ListNode?) {
        if (n0?.next == null) {
            return
        }
        val p = n0.next
        val n1 = p?.next
        n0.next = n1
    }

    /**
     * 访问节点
     * 反问链表中索引为index的节点
     * 在链表中，反问节点的效率较低，需要从头向后遍历节点，时间复杂度为O(n)
     */
    fun access(head: ListNode?, index: Int): ListNode? {
        var h = head
        for (i in 0..<index) {
            if (h == null) {
                return null
            }
            h = h.next
        }
        return h
    }

    /**
     * 查找节点
     * 查找值为target的节点，输出该节点在链表中的索引
     * 为线性查找，时间复杂度为O(n)
     */
    fun find(head: ListNode?, target: Int): Int {
        var index = 0
        var h = head
        while (h != null) {
            if (h.`val` == target) {
                return index
            }
            h = h.next
            index++
        }
        return -1
    }
}