package io.archie.algorithm.leetcodeClassic;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @Author: MrArchie
 * @Date: 2024/10/15 11:33
 */
public class Code209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        int minLength = 0;
        int tempValue = 0;
        while (right < n) {
            tempValue += nums[right];
            while (tempValue >= target) {
                if(minLength == 0){
                    minLength = right - left +1;
                }else {
                    minLength = Math.min(minLength, right - left+1);
                }
                tempValue -= nums[left];
                left++;
            }
            right++;
        }
        return minLength;
    }
}