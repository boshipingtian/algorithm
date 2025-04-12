package io.archie.algorithm.leetcodeHot;

import io.archie.algorithm.helper.TreeNode;

/**
 * 反转二叉树 <a href="https://leetcode.cn/problems/invert-binary-tree/?envType=problem-list-v2&envId=2cktkvj" />
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 22:41
 */
public class Code226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static void main(String[] args) {
        Code226 code226 = new Code226();

        TreeNode tree1 = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(2)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        TreeNode treeNode = code226.invertTree(tree1);
        System.out.println("treeNode = " + treeNode);
    }
}