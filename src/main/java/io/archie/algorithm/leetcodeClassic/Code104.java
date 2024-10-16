package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 18:03
 */
public class Code104 {

    public static void main(String[] args) {
        // 3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3, 
            new TreeNode(9, null ,null), new TreeNode(20, 
            new TreeNode(15, null ,null), new TreeNode(7, null ,null)));
        System.out.println(maxDepth_BFS(root));
        System.out.println(maxDepth_DFS(root));
    }

    public static int maxDepth_BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    public static int maxDepth_DFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth_DFS(root.left);
        int right = maxDepth_DFS(root.right);
        return Math.max(left, right) + 1;
    }

}