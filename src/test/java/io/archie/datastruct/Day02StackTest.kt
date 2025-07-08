package io.archie.datastruct

import org.junit.Assert.assertEquals
import org.junit.Test

class Day02StackTest {
    val day02Stack = Day02Stack()

    @Test
    fun kotlinStack() {
        day02Stack.kotlinStack()
    }

    @Test
    fun linkedListStack() {
        val stack = Day02Stack.LinkedListStack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.pop())
        println(stack.toArray().toList())
    }

    @Test
    fun arrayStack() {
        val stack = Day02Stack.ArrayStack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.pop())
        println(stack.toArray().toList())
    }

}