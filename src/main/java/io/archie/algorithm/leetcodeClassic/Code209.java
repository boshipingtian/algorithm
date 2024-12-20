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

    public static void main(String[] args) {
        Code209 code209 = new Code209();

        int[] nums1 = {1,1,1,1,1,1,1,1};
        int target1 = 11;
        int ans1 = code209.minSubArrayLen2(target1, nums1);
        System.out.println("ans1 = " + ans1);
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        int minLength = 0;
        int tempValue = 0;
        while (right < n) {
            tempValue += nums[right];
            while (tempValue >= target) {
                if (minLength == 0) {
                    minLength = right - left + 1;
                } else {
                    minLength = Math.min(minLength, right - left + 1);
                }
                tempValue -= nums[left];
                left++;
            }
            right++;
        }
        return minLength;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int min = 0;
        int temp = 0;
        for (right = 0; right < n; right++) {
            temp = temp + nums[right];
            while (left <= right && temp >= target) {
                if (min == 0) {
                    min = right - left + 1;
                } else {
                    min = Math.min(min, (right - left + 1));
                }
                temp = temp - nums[left];
                left++;
            }
        }
        return min;
    }
}