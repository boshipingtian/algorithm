package io.archie.datastruct

import io.archie.algorithm.helper.TreeNode
import java.util.LinkedList

/**
 * # 二叉搜索树
 * 二叉搜索树满足以下条件：
 * 1. 对于根节点，左子树所有节点的值 < 根节点的值 < 右子树所有节点的值
 * 2. 任意节点的左右子树也是二叉搜索树，满足条件1
 *
 * # 二叉搜索树的操作
 *
 * ## 查找节点
 * 二叉搜索树查找操作与二分查找原理一致，每次排出一半的情况，循环次数最多为二叉树的高度。
 * 当二叉树平衡时，使用O(log n)的时间
 *
 * ## 插入节点
 * 给定一个待插入元素，操作流程如下：
 * 1. 查找插入节点，与查找操作类似，直到越过叶子节点，Null
 * 2. 在该位置插入节点
 */
class Day04BinarySearchTree {

    private val treeNode = TreeNode(
        8,
        TreeNode(
            4,
            TreeNode(
                2,
                TreeNode(1),
                TreeNode(3)
            ),
            TreeNode(
                6,
                TreeNode(5),
                TreeNode(7)
            )
        ),
        TreeNode(
            12,
            TreeNode(
                10,
                TreeNode(9),
                TreeNode(11)
            ),
            TreeNode(
                14,
                TreeNode(13),
                TreeNode(15)
            )
        )
    )

    /**
     * 搜索节点，时间复杂度O(log n)
     */
    fun search(value: Int): TreeNode? {
        var root = treeNode;
        while (root != null) {
            if (root.`val` == value) {
                break
            } else if (root.`val` > value) {
                root = root.left
            } else {
                root = root.right
            }
        }
        return root
    }

    /**
     * 插入节点
     */
    fun insert(value: Int) {
        var preNode = treeNode
        var root = treeNode
        while (root != null) {
            if (root.`val` < value) {
                preNode = root
                root = root.right
            } else if (root.`val` > value) {
                preNode = root
                root = root.left
            } else {
                return
            }
        }
        // 遍历到了头
        val newNode = TreeNode(value)
        if (preNode.`val` > value) {
            preNode.left = newNode
        } else {
            preNode.right = newNode
        }
    }
}