package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code1 {

    public static void main(String[] args) {
        Code1 code1 = new Code1();

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ints = code1.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int i = 0;
        int res = 0;
        while (i < nums.length) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                res = map.get(val);
                if (res != i) {
                    break;
                }
            }
            i++;
        }
        return new int[]{i, res};
    }
}
