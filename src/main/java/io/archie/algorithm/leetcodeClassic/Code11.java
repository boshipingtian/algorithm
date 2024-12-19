package io.archie.algorithm.leetcodeClassic;

public class Code11 {

    public static void main(String[] args) {
        Code11 code11 = new Code11();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("code11.maxArea(height) = " + code11.maxArea(height));
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            max = height[left] < height[right]
                    ? Math.max(max, (right - left) * height[left++])
                    : Math.max(max, (right - left) * height[right--]);
        }
        return max;
    }

}
