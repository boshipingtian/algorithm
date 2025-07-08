package io.archie.datastruct

import org.junit.Assert.*
import org.junit.Test

class Day02QueueTest {
    val day02Queue = Day02Queue()

    @Test
    fun kotlinQueue() {
        day02Queue.kotlinQueue()
    }

    @Test
    fun linkedQueueTest() {
        val linkedQueue = Day02Queue.LinkedQueue()
        linkedQueue.offer(1)
        linkedQueue.offer(2)
        linkedQueue.offer(3)
        linkedQueue.offer(4)
        println(linkedQueue.peek())
        println(linkedQueue.poll())
        println(linkedQueue.toArray().toList())
    }

    @Test
    fun arrayQueueTest() {
        val arrayQueue = Day02Queue.ArrayQueue(5)
        arrayQueue.offer(1)
        arrayQueue.offer(2)
        arrayQueue.offer(3)
        arrayQueue.offer(4)
        arrayQueue.offer(5)
        println(arrayQueue.poll())
        println(arrayQueue.poll())
        arrayQueue.offer(6)
        println(arrayQueue.toArray().toList())
    }

}