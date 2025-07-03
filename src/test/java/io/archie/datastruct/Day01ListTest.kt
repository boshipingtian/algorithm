package io.archie.datastruct

import org.junit.Assert.*
import org.junit.Test

class Day01ListTest {

    val list = Day01List()

    @Test
    fun init() {
        val init = list.init()
        println(init)
    }

    @Test
    fun testInit() {
        val init = list.init(1, 2, 3, 4)
        println(init)
    }

    @Test
    fun find() {
        val init = list.init(1, 2, 3, 4)
        println(list.find(init.toMutableList(), 2))
        val mutableList = init.toMutableList()
        list.find(mutableList, 2, -1)
        println(mutableList)
    }

    @Test
    fun insert() {
        val init = list.init(1, 2, 3, 4).toMutableList()
        list.insert(init, 1, -1)
        println(init)
    }

    @Test
    fun remove() {
        val init = list.init(1, 2, 3, 4).toMutableList()
        list.remove(init, 2)
        println(init)
    }

    @Test
    fun traverse() {
        val init = list.init(10, 5, 3, 4)
        list.traverse(init)
    }

    @Test
    fun concat() {
        val init1 = list.init(1, 2, 3, 4)
        val init2 = list.init(10, 5, 3, 4)
        val concat = list.concat(init1, init2)
        println(concat)
    }

    @Test
    fun sort() {
        val init1 = list.init(1, 2, 3, 4)
        val init2 = list.init(10, 5, 3, 4)
        val concat = list.concat(init1, init2)
        println(list.sort(concat))
    }

    @Test
    fun myListTest(){
        val myList = Day01List.MyList()
        myList.add(1)
        myList.add(2)
        myList.add(3)
        myList.add(4)
        myList.add(5)
        myList.add(6)
        myList.add(7)
        myList.add(8)
        myList.add(9)
        myList.add(10)
        myList.add(11)
        println(myList.toArray())
    }

}