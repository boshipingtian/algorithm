package io.archie.algorithm.leetcodeHot;

import io.archie.algorithm.helper.TreeNode;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 21:04
 */
public class Code236 {

    /**
     * DFS，递归到最底层，判断当前root是不是p q的最近公共祖先
     * 如果返回的left、right都不是空，说明root就是最近公共祖先
     * 如果left、right都是空，则没有最近公共祖先
     * 如果left为空，说明不在left这一侧，返回right
     * 如果right为空，说明不在right这一侧，返回left
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(
            3,
            new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
            new TreeNode(1, new TreeNode(0), new TreeNode(8))
        );
        TreeNode p2 = new TreeNode(7);
        TreeNode q2 = new TreeNode(4);

        Code236 code236 = new Code236();
        TreeNode ans2 = code236.lowestCommonAncestor(treeNode2, p2, q2);
        System.out.println("ans2 = " + ans2.val);
    }
}