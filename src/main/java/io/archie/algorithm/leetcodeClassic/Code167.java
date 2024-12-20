package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class Code167 {

    public static void main(String[] args) {
        Code167 code167 = new Code167();

        int[] nums1 = {-10, -8, -2, 1, 2, 5, 6};
        int target1 = 0;
        int[] ans1 = code167.twoSum3(nums1, target1);
        System.out.println("ans1 = " + Arrays.toString(ans1));
    }

    /**
     * 定义双指针，因为题目说是非递减，也就是前一个数 <= 后一个数
     * <p>
     * left指针固定后，right指针向后寻找target-left的值
     * 如果找不到，left++，right=left+1;
     * 直到 left < n -1
     * <p>
     * 时间复杂度为O(n!)，假设numbers长度为n，最坏情况为n！次遍历
     * 空间复杂度为0(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = 1;
        int n = numbers.length;
        while (left < n - 1) {
            int t = target - numbers[left];
            while (right < n) {
                if (numbers[right] == t) {
                    return new int[]{left + 1, right + 1};
                } else if (numbers[right] > t) {
                    break;
                }
                right++;
            }
            left++;
            right = left + 1;
        }
        return new int[]{left + 1, right + 1};
    }

    /**
     * 使用哈希方式尝试
     * 定义一个hashmap，把所有数据存储到map中
     * 遍历数组查找 target-numbers[i] 在map中存在，获取index值
     * <p>
     * 时间复杂度为O(2N)
     * 空间复杂度为O(N)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i + 1, map.get(target - numbers[i]) + 1};
            }
        }
        return null;
    }

    /**
     * 使用双指针解法，题型类似与 柱状图能接最大水量题, 因为输入的数组非递减，所以可以利用这个性质
     * <p>
     * 使用left，right指针，left = 0，right = n-1；
     * <p>
     * 判断
     * 1. 如果 nums[left] + nums[right] == target 返回答案
     * 2. 如果 nums[left] + nums[right] < target left++
     * 3. 如果 nums[left] + nums[right] > target right--
     * 4. 如果left >= right 退出，返回结果[-1,-1]
     *
     * 时间复杂度为O(N)
     * 空间复杂度为O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int val = numbers[left] + numbers[right];
            if (val == target) {
                return new int[]{left + 1, right + 1};
            } else if (val < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
