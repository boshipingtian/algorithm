package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Code105 {
    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构建哈希
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        // 判断某一个遍历的变量是否有效
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 先找根节点
        int preorderRoot = preorderLeft;
        // 找到根节点的位置
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 从中序遍历中 可以获取到左子树的长度
        int sizeLeftSubtree = inorderRoot - inorderLeft;

        // 根据中序遍历中左子树的长度，可以从前序遍历中找到子节点的root，根据root在中序遍历的坐标依次循环遍历
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
