package io.archie.datastruct

import io.archie.algorithm.helper.TreeNode

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
 *
 * ## 删除节点
 * 给定一个元素，操作流程如下
 * 1. 找到该节点和父节点（O(log n)）
 * 2. 判断该节点的度，0，1，2
 *   1. 如果为0，即没有子节点，直接删除此节点
 *   2. 如果为1，即有一个子节点，则直接替换要删除的节点
 *   3. 如果为2，即有两个子节点，为了保持二叉搜索树的性质，一般取左子树最大节点、右子树最小节点作为替换节点。同时，使用递归删除替换节点。
 *
 * ## 二叉搜索树的效率
 *
 * | | 无序数组 | 二叉树 |
 * | :--- | :---: | :---: |
 * | 查找元素 | O(n) | O(log n) |
 * | 插入元素 | O(1) | O(log n) |
 * | 删除元素 | O(n) | O(log n) |
 *
 * ## 二叉搜索树退化
 * 理想情况下，二叉搜索树是“平衡”的，这样可以在log n轮循环内查找任意节点。
 * 但是随着不断插入和删除节点，可能导致二叉树退化为链表，时间复杂度也会退化为O(n)
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
        var preNode: TreeNode = treeNode
        var root: TreeNode? = treeNode
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

    /**
     * # 删除节点
     * - 1. 该节点的度为0，即没有子节点，查找后直接删除即可
     * - 2. 该节点的度为1，即有一个子节点，删除后替换原节点的位置即可
     * - 3. 该节点的度为2，即有两个子节点，删除时需要处理子节点以便符合二叉搜索树的性质
     *   - 左子树<中节点<右子树
     *   - 可以选择使用左子树最大值或者右子树最小值作为新的中间节点，假设我们使用右子树的最小节点。
     */
    fun delete(value: Int) {
        // 如果树为空，直接提前返回
        var root = treeNode
        if (root == null) {
            return
        }
        // 找到这个节点
        var cur = root
        var pre: TreeNode? = root;
        // 循环查找，找到叶子节点后跳出
        while (cur != null) {
            if (cur.`val` == value) {
                break
            }
            pre = cur
            // 待删除的节点在cur的右子树
            cur = if (cur.`val` < value) {
                cur.right
            } else {
                cur.left
            }
        }
        // 如果没有待删除节点，直接返回
        if (cur == null) {
            return
        }
        // 子节点数量为0、1
        if (cur.left == null || cur.right == null) {
            // 当子节点数量 = 0 / 1 时，child = null / 该子节点
            val child = if (cur.left != null) {
                cur.left
            } else {
                cur.right
            }
            // 删除节点cur
            if (cur != root) {
                if (pre?.left == cur) {
                    pre.left = child
                } else {
                    pre?.right = child
                }
            } else {
                // 如果删除的节点为根节点，则重新制定根节点
                root = child
            }
        } else {
            // 度为2
            // 获取中序遍历中cur的下一个节点
            var tmp = cur.right
            while (tmp.left != null) {
                tmp = tmp.left
            }
            // 递归删除节点tmp
            delete(tmp.`val`)
            // 用tmp覆盖cur
            cur.`val` = tmp.`val`
        }
        return
    }

    /**
     * # 中序遍历
     * 因为二叉搜索树有 左子树<中间节点<右子树，而中序遍历顺序为 左->中->右，这就意味着：
     * 1. 二叉搜索树在中序遍历时，总会优先遍历下一个最小节点。
     * 2. 二叉搜索树的中序遍历是升序的。
     * 3. 二叉搜索树中获取有序数据仅需O(n)时间，无需额外排序
     */
    fun depthFirstTraversalMiddle(): Array<Int?> {
        val root = treeNode;
        val res = mutableListOf<Int?>()
        dfs(root, res);
        return res.toTypedArray();
    }

    fun dfs(root: TreeNode, arr: MutableList<Int?>) {
        if (root == null) {
            return
        }
        if (root.left != null) {
            dfs(root.left, arr)
        }
        arr.add(root.`val`)
        if (root.right != null) {
            dfs(root.right, arr)
        }
    }
}