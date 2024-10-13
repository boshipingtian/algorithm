package io.archie.algorithm.helper;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 18:03
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}