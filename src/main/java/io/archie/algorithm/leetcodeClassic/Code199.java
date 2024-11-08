package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        myRightSileView(res, root);
        return res;
    }

    public static void myRightSileView(List<Integer> list, TreeNode root){
        if(root != null){
            list.add(root.val);
            myRightSileView(list, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1, new TreeNode(2), null);
    }
}
