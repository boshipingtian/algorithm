package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Code106 {

    public static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        int inorderRootIndex = indexMap.get(postorder[postorderRight]);
        TreeNode root = new TreeNode(inorder[inorderRootIndex]);

        int leftSubtreeSize = inorderRootIndex - inorderLeft;
        root.left = myBuildTree(inorder, postorder, inorderLeft, inorderRootIndex - 1, postorderLeft, postorderLeft + leftSubtreeSize-1);
        root.right = myBuildTree(inorder, postorder, inorderRootIndex+1, inorderRight, postorderLeft + leftSubtreeSize, postorderRight-1);
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}