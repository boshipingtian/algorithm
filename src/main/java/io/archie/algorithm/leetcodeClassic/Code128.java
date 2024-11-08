package io.archie.algorithm.leetcodeClassic;

import java.util.HashSet;
import java.util.Set;

public class Code128 {

    public static void main(String[] args) {
        int[] test1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(test1));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int temp = num + 1;
            int tempMax = 1;
            while (set.contains(temp)) {
                temp++;
                tempMax++;
            }
            maxLength = Math.max(maxLength, tempMax);
        }
        return maxLength;
    }
}
