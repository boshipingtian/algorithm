package io.archie.datastruct

import org.junit.Assert.*
import org.junit.Test

class Day04BinarySearchTreeTest {

    private val binarySearchTree = Day04BinarySearchTree()

    @Test
    fun search() {
        val search = binarySearchTree.search(5)
        println(search?.`val`)
    }

    @Test
    fun insert() {
        binarySearchTree.insert(16)
    }

    @Test
    fun delete() {
        binarySearchTree.delete(4)
    }

    @Test
    fun depthFirstTraversalMiddle(){
        println(binarySearchTree.depthFirstTraversalMiddle().toList())
    }

}