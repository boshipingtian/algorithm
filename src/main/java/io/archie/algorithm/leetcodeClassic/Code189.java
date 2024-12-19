package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 12:59
 */
public class Code189 {

    public static void main(String[] args) {
        Code189 code189 = new Code189();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        code189.rotate(nums, k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int rk = k % n;
        int[] newNums = new int[n];

        for (int i = 0; i < n; i++) {
            newNums[(rk+i)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }
    }

}