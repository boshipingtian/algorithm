package io.archie.algorithm.leetcodeClassic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/10 22:17
 */
public class Code169 {

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = (int) (0.5 + (double) nums.length / 2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        AtomicInteger forReturn = new AtomicInteger(-1);
        map.forEach((key, value) -> {
            if (value >= n) {
                forReturn.set(key);
            }
        });
        return forReturn.get();
    }
}