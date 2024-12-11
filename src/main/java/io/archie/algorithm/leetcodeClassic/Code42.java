package io.archie.algorithm.leetcodeClassic;

public class Code42 {

    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = 1;
        int max = 0;
        while (right < n) {
            if (height[left] > height[right]) {
                while (right < n && height[right] >= height[left]) {
                    max += height[left] - height[right];
                    right++;
                }
                left = right;
                right++;
            } else {
                right++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(test1));
    }
}
