package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 12:31
 */
public class Code88 {

    public static void main(String[] args) {
        Code88 code88 = new Code88();
        
        int[] num1 = {1,2,3,0,0,0};
        int m= 3;
        int[] num2 = {2,5,6};
        int n = 3;
        code88.merge(num1, m, num2, n);

        System.out.println("num1 = " + Arrays.toString(num1));
    }


    /**
     * 我的思路：
     * 
     * 从后往前遍历两个数组，找到大的那个，放到num1里面，直到便利到头
     *
     * @param nums1 nums1
     * @param m     米
     * @param nums2 nums2
     * @param n     n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sort = m+n-1; // 最后要放的位置
        int l1 = m-1;
        int l2 = n-1;
        while(l1 >= 0 || l2 >= 0){
            if(l1 == -1){
                nums1[sort] = nums2[l2];
                l2--;
            }else if (l2 == -1){
                nums1[sort] = nums1[l1];
                l1--;
            } else if(nums1[l1] > nums2[l2]){
                nums1[sort] = nums1[l1];
                l1--;
            }else {
                nums1[sort] = nums2[l2];
                l2--;
            }
            sort--;
        }
    }
}