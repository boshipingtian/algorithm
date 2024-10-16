package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 19:10
 */
public class Code101 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(node != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                size--;
            }
            TreeNode[] array = queue.toArray(new TreeNode[]{});
            int i=0,j=array.length-1;
            while(i<j){
                if(array[i] == null && array[j] == null){
                    i++;
                    j--;
                   continue; 
                }
                if((array[i] == null || array[j] == null )||array[i].val != array[j].val){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}