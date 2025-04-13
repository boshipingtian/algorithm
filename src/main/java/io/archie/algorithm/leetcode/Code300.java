package io.archie.algorithm.leetcode;

/**
 * 最长递增子序列 https://leetcode.cn/problems/longest-increasing-subsequence/description<br> 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @Author: MrArchie
 * @Date: 2025/4/13 20:41
 */
public class Code300 {

    private int[] nums;
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n]; // 本题可以初始化成 0，表示没有计算过
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                memo[i] = Math.max(memo[i], dfs(j));
            }
        }
        return ++memo[i]; // 加一提到循环外面
    }

    public static void main(String[] args) {
        Code300 code300 = new Code300();

        int[] nums1 = {0,1,0,3,2,3};
        int res1 = code300.lengthOfLIS(nums1);
        System.out.println("res1 = " + res1);
    }
}