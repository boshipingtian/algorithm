package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 12:34
 */
public class Code238 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] la = new int[n];
        int[] ra = new int[n];
        la[0] = 1;
        ra[n-1] = 1;
        int i =1;
        int j = n-2;
        while(i<n && j>=0){
            la[i] = nums[i-1] * la[i-1];
            ra[j] = nums[j+1] * ra[j+1];
            i++;
            j--;
        }
        int[] res = new int[n];
        for(int k=0;k<n;k++){
            res[k] = la[k] * ra[k];
        }
        return res;
    }
}