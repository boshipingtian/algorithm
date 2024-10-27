package io.archie.algorithm.huawei.meet;

/**
*  <br>
*
* @Author: MrArchie
* @Date: 2024/10/13 18:18
*/
public class LeetCode209 {

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen2(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = 0;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int tempValue = 0;
                for (int i = left; i <= right; i++) {
                    tempValue += nums[i];
                }
                if(tempValue >= target){
                    if(minLength == 0){
                        minLength = right-left+1;
                    }else {
                        minLength = Math.min(right-left+1, minLength);
                    }
                    break;
                }
            }
        }
        return minLength;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int minLength = 0;
        int left = 0,right =0;
        
        int tempValue = 0;
        while(right<n){
            tempValue += nums[right];
            while (tempValue >= target){
                if(minLength == 0) {
                    minLength = right - left + 1;
                }else {
                    minLength = Math.min(right-left+1, minLength);
                }
                tempValue -= nums[left];
                left++;
            }
            right++;
        }
        return minLength;
    }
}