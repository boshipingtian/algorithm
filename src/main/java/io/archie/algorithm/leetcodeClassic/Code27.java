package io.archie.algorithm.leetcodeClassic;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 12:45
 */
public class Code27 {

    public static void main(String[] args) {
        Code27 code27 = new Code27();
        
        int[] nums = {3,2,2,3};
        int val = 3;

        int i = code27.removeElement(nums, val);
        System.out.println("i = " + i);
    }

    /**
     * 我的思路：双指针，定义两个left，right指针，开始时都是0，然后让right向后便利数组
     * 如果和val不一样，就把left元素替换，同时left++；
     * 最后返回left
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right;
        int n = nums.length;
        for (right = 0; right < n; right++) {
            if(nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}