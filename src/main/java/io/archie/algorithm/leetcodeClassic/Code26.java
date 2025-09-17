package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.SortHelper;
import java.util.HashSet;
import java.util.Set;

/**
 * 26. 删除有序数组中的重复项<br> 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums
 * 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。 返回 k 。
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4] 输出：5, nums = [0,1,2,3,4] 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
 * 。不需要考虑数组中超出新长度后面的元素。
 *
 * @Author: MrArchie
 * @Date: 2024/10/10 11:04
 */
public class Code26 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2_1(nums));
    }

    public static int removeDuplicates1_1(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int l = 0, r = 0;
        while (l <= r && l < nums.length && r < nums.length) {
            int lv = nums[l];
            if (sets.contains(lv)) {
                try {
                    while (sets.contains(nums[r])) {
                        r++;
                    }
                } catch (Exception e) {
                    return l;
                }
                SortHelper.swap(l, r, nums);
                sets.add(nums[l]);
            } else {
                sets.add(lv);
            }
            l++;
            r++;
        }
        return l;
    }

    public static int removeDuplicates1_2(int[] nums) {
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //    输入：nums = [0,0,1,1,1,1,2,3,3]
//    输出：7, nums = [0,0,1,1,2,3,3]
    public static int removeDuplicates2_1(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;

        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}