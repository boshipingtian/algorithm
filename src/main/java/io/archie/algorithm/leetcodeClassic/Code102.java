package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历 <br>
 *
 * @Author: MrArchie
 * @Date: 2025/3/30 20:50
 */
public class Code102 {

    public static void main(String[] args) {
        // root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        List<List<Integer>> lists = new Code102().levelOrder(root);
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            int i = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(i > 0){
                TreeNode node = queue.poll();
                if (node.left != null) {
                    temp.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right.val);
                    queue.offer(node.right);
                }
                i--;
            }
            if(!temp.isEmpty()){
                res.add(temp);
            }
        }
        return res;
    }
}