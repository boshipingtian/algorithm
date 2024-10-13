package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 18:23
 */
public class Code100 {

    public static void main(String[] args) {
        TreeNode treeP = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeQ = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree_BFS(treeP, treeQ));
    }

    public static boolean isSameTree_DFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree_DFS(p.left, q.left) && isSameTree_DFS(p.right, q.right);
    }

    public static boolean isSameTree_BFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(p);
        tree.offer(q);
        while (!tree.isEmpty()) {
            TreeNode nodeP = tree.poll();
            TreeNode nodeQ = tree.poll();
            if(nodeP ==null && nodeQ == null){
                continue;
            }
            if ((nodeP == null || nodeQ == null) || nodeP.val != nodeQ.val) {
                return false;
            }
            tree.offer(nodeP.left);
            tree.offer(nodeQ.left);
            tree.offer(nodeP.right);
            tree.offer(nodeQ.right);
        }
        return true;
    }
}