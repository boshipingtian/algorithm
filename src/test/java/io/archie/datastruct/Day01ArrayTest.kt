package io.archie.datastruct

import org.junit.Test

class Day01ArrayTest {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val day01Array = Day01Array()

    @Test
    fun extend() {
        val extend = day01Array.extend(array, 5)
        println(extend.joinToString())
    }

    @Test
    fun find() {
        val find = day01Array.find(array, 5)
        println(find)
    }

    @Test
    fun remove() {
        day01Array.remove(array, 3)
        println(array.joinToString())
    }

    @Test
    fun insert() {
        day01Array.insert(array, 3, 3)
        println(array.joinToString(", ", "[", "]"))
    }

    @Test
    fun randomAccess() {
        day01Array.randomAccess();
    }
}