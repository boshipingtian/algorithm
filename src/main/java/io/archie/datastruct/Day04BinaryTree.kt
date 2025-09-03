package io.archie.datastruct

import io.archie.algorithm.helper.TreeNode
import java.util.LinkedList

/**
 * # 二叉树
 *
 * 树是一种数据结构，它是由n个有限节点组成一个具有层次关系的集合。
 * 树的节点分为根节点、子节点、父节点、叶子节点等。
 * 树的高度是指树的最大深度，树的深度是指从根节点到叶子节点的最长路径长度。
 *
 * ## 完美二叉树
 * 完美二叉树所有层的节点都被完全填满。在完美二叉树中，叶节点的度为0，其余所有节点的度都为2；
 * 若树的高度为h，则节点总数为2^(h+1) - 1。呈现指数级关系。
 *
 * ## 完全二叉树
 * 完全二叉树仅允许最底层的节点不完全填满，切最底层的节点必须从左到右依次连续填充
 * 完美二叉树也是一颗完全二叉树
 *
 * ## 完满二叉树
 * 除了叶子节点外，其余所有节点都有两个字节点，即所有节点的度为0或2
 *
 * ## 平衡二叉树
 * 平衡二叉树中任意节点的左子树和右子树的高度差绝对值不超过1
 *
 * ## 红黑树
 * 红黑树是一种自平衡的二叉搜索树，它通过颜色标记来保持树的平衡。
 * 红黑树的每个节点都有一个颜色属性，红色或黑色。
 * 红黑树的性质：
 * 1. 每个节点都是红色或黑色
 * 2. 根节点是黑色
 * 3. 每个叶子节点（NIL节点）是黑色
 * 4. 如果一个节点是红色，则它的两个子节点都是黑色
 * 5. 从任何节点到其每个叶子节点的所有路径都包含相同数量的黑色节点
 */
class Day04BinaryTree {

    /**
     * 初始化二叉树
     */
    fun initBinaryTree(): Unit {
        val treeNode = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
        println(treeNode)
    }

    /**
     * ## 层序遍历
     * 层序遍历从顶部到底部逐层遍历二叉树，并在每一层按照从左到右的顺序访问节点。
     * 本质上属于广度优先遍历，也叫广度优先搜索（BFS）
     * 时间复杂度O(n)
     * 空间复杂度O(n) 队列中最多存在(n+1)/2个元素
     */
    fun levelOrderTraversal(treeNode: TreeNode) {
        val queue = LinkedList<TreeNode>()
        queue.offer(treeNode)
        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            println(pop.`val`)
            if (pop.left != null) {
                queue.offer(pop.left)
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
    }

    /**
     * ## 前、中、后序遍历
     * 前序、中序和后序遍历都属于深度优先遍历（depth-first traversal），
     * 也称深度优先搜索（depth-first search, DFS）
     * 它体现了一种“先走到尽头，再回溯继续”的遍历方式。
     * 时间复杂度O(n)
     * 空间复杂度O(n) 最差情况下，树退化成链表，递归深度达到n，系统占用O(n)的栈帧空间
     */
    fun depthFirstTraversalPrev(tree: TreeNode) {
        println(tree.`val`)
        if (tree.left != null) {
            depthFirstTraversalPrev(tree.left)
        }
        if (tree.right != null) {
            depthFirstTraversalPrev(tree.right)
        }
    }

    fun depthFirstTraversalMiddle(tree: TreeNode) {
        if (tree.left != null) {
            depthFirstTraversalMiddle(tree.left)
        }
        println(tree.`val`)
        if (tree.right != null) {
            depthFirstTraversalMiddle(tree.right)
        }
    }

    fun depthFirstTraversalTail(tree: TreeNode) {
        if (tree.left != null) {
            depthFirstTraversalTail(tree.left)
        }
        if (tree.right != null) {
            depthFirstTraversalTail(tree.right)
        }
        println(tree.`val`)
    }

    /**
     * ## 二叉树的数组表示
     * ### 表示完美二叉树
     * 根据层序遍历的特性，可以推导出父节点索引与子节点索引之间的“映射公式”：
     * 若某节点的索引为i，则该节点的左子节点索引为2i+1，右子节点索引为2i+2
     */
    fun representsBinaryTree() {
        val tree = TreeNode(
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
        println(tree)
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7)
        println(arr)
    }

    /**
     * ### 表示任意二叉树
     *
     * 一般来说，在二叉树的中间层通常存在很多Null，使用层序遍历通常不包含这些Null。因此无法单从层序遍历序列反推出二叉树结构
     * 为了解决此问题，可以考虑在层序遍历序列中显示写出所有Null，这样可以唯一的表示二叉树了。
     * 同时也引发了一些新问题，Null数量过多会导致数组空间利用率不高，而且使数组分配过多无用的内存空间。
     * [图片](https://www.hello-algo.com/chapter_tree/array_representation_of_tree.assets/array_representation_with_empty.png)
     * 但是，完全二叉树非常适合使用数组表示，因为Null值出现在最底层右侧的位置，因此在层序遍历中，Null一定出现在数组末尾，因此可以省略存储所有Null。
     * [图片](https://www.hello-algo.com/chapter_tree/array_representation_of_tree.assets/array_representation_complete_binary_tree.png)
     *
     * 下面是一个基于数组表示的二叉树，提供以下几种操作
     * - 给定某节点，获取他的值，左右子节点，父节点。
     * - 获取前序、中序、后序、层序遍历结果
     *
     * ## 总结
     */
    class ArrayBinaryTree(val arr: Array<Int?>) {

        /**
         * 获取某个节点的值，索引值
         */
        fun value(index: Int): Int? {
            if (index < 0 || index >= arr.size) {
                return null
            }
            return arr[index]
        }

        /**
         * 根据索引值获取节点的左、右节点
         */
        fun children(index: Int): Pair<Int?, Int?> {
            if (index < 0 || index >= arr.size) {
                return null to null
            }
            val left = if (2 * index + 1 >= arr.size) {
                null
            } else {
                arr[2 * index + 1]
            }
            val right: Int? = if (2 * index + 2 >= arr.size) {
                null
            } else {
                arr[2 * index + 2]
            }
            return Pair(left, right)
        }

        /**
         * 根据索引值获取节点的左、右节点
         */
        private fun childrenIndex(index: Int): Pair<Int?, Int?> {
            if (index < 0 || index >= arr.size) {
                return null to null
            }
            return Pair(2 * index + 1, 2 * index + 2)
        }


        /**
         * 获取父节点
         */
        fun parent(index: Int): Int? {
            if (index < 0 || index >= arr.size) {
                return null
            }
            if (index == 0) {
                return null
            }
            return arr[(index - 1) / 2]
        }

        enum class TraversalOrder {
            PRE, MIDDLE, TAIL
        }

        private fun dsf(index: Int, order: TraversalOrder, result: MutableList<Int?>) {
            if (index >= arr.size || arr[index] == null) {
                return
            }
            if (order == TraversalOrder.PRE) {
                result.add(arr[index])
            }
            val children = childrenIndex(index)
            dsf(children.first ?: return, order, result)
            if (order == TraversalOrder.MIDDLE) {
                result.add(arr[index])
            }
            dsf(children.second ?: return, order, result)
            if (order == TraversalOrder.TAIL) {
                result.add(arr[index])
            }
        }

        /**
         * 获取前序遍历结果
         */
        fun depthFirstTraversalPrev(): Array<Int?> {
            val res = mutableListOf<Int?>()
            dsf(0, TraversalOrder.PRE, res)
            return res.toTypedArray()
        }

        /**
         * 获取中序遍历结果
         */
        fun depthFirstTraversalMiddle(): Array<Int?> {
            val res = mutableListOf<Int?>()
            dsf(0, TraversalOrder.MIDDLE, res)
            return res.toTypedArray()
        }

        /**
         * 获取后序遍历结果
         */
        fun depthFirstTraversalTail(): Array<Int?> {
            val res = mutableListOf<Int?>()
            dsf(0, TraversalOrder.TAIL, res)
            return res.toTypedArray()
        }
    }
}