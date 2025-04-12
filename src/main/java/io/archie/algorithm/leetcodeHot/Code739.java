package io.archie.algorithm.leetcodeHot;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/?envType=problem-list-v2&envId=2cktkvj"/>
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 22:20
 */
public class Code739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                nums[index] = i;
            }
            stack.push(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] > 0 ? nums[i] - i : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        Code739 code739 = new Code739();
        int[] ans1 = code739.dailyTemperatures(temperatures1);
        System.out.println("ans1 = " + Arrays.toString(ans1));

        int[] temperatures2 = {30,40,50,60};
        int[] ans2 = code739.dailyTemperatures(temperatures2);
        System.out.println("ans2 = " + Arrays.toString(ans2));
    }
}