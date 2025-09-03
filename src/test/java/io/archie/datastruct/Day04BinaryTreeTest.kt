package io.archie.datastruct

import io.archie.algorithm.helper.TreeNode
import org.junit.Assert.*
import org.junit.Test

class Day04BinaryTreeTest {

    private val binaryTree = Day04BinaryTree()

    private val arrayBinaryTree = Day04BinaryTree.ArrayBinaryTree(arrayOf(1, 2, 3, 4, 5, 6, 7))

    private val tree = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(4),
            TreeNode(5)
        ),
        TreeNode(
            3,
            TreeNode(6),
            TreeNode(7)
        )
    )

    @Test
    fun initBinaryTree() {
        binaryTree.initBinaryTree()
    }

    @Test
    fun levelOrderTraversal() {
        binaryTree.levelOrderTraversal(tree)
    }

    @Test
    fun depthFirstTraversalPrev() {
        binaryTree.depthFirstTraversalPrev(tree)
    }

    @Test
    fun depthFirstTraversalMiddle() {
        binaryTree.depthFirstTraversalMiddle(tree)
    }

    @Test
    fun depthFirstTraversalTail() {
        binaryTree.depthFirstTraversalTail(tree)
    }

    @Test
    fun arrayTreeTest(){
        // 1,2,3,4,5,6,7
        println(arrayBinaryTree.value(1))
        println(arrayBinaryTree.children(1))
        println(arrayBinaryTree.parent(1))
        println(arrayBinaryTree.depthFirstTraversalPrev().toList())
        println(arrayBinaryTree.depthFirstTraversalMiddle().toList())
        println(arrayBinaryTree.depthFirstTraversalTail().toList())
    }
}