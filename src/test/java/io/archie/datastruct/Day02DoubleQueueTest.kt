package io.archie.datastruct

import org.junit.Assert.*
import org.junit.Test

class Day02DoubleQueueTest {
    val day02DoubleQueue = Day02DoubleQueue()

    @Test
    fun kotlinDoubleQueue() {
        day02DoubleQueue.kotlinDoubleQueue()
    }

    @Test
    fun doubleQueueTest(){
        val queue = Day02DoubleQueue.LinkedListDoubleQueue()
        queue.offerFirst(1)
        queue.offerFirst(2)
        queue.offerFirst(3)
        queue.offerFirst(4)
        queue.offerLast(5)
        queue.offerLast(6)
        queue.offerLast(7)
        println(queue.toArray().toList())

        println(queue.popFirst())
        println(queue.popLast())

        println(queue.toArray().toList())
    }

    @Test
    fun arrayDoubleQueueTest(){
        val queue = Day02DoubleQueue.ArrayDoubleQueue(10)
        queue.offerFirst(1)
        queue.offerFirst(2)
        queue.offerFirst(3)
        queue.offerFirst(4)
        queue.offerLast(5)
        queue.offerLast(6)
        queue.offerLast(7)
        println(queue.toArray().toList())

        println(queue.popFirst())
        println(queue.popLast())

        println(queue.toArray().toList())
    }

}