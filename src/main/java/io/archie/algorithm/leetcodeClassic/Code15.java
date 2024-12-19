package io.archie.algorithm.leetcodeClassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {

    public static void main(String[] args) {
        Code15 code15 = new Code15();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = code15.threeSum(nums);
        System.out.println("lists = " + lists);
    }

    /**
     * 思路：
     * [-1,0,1,2,-1,-4]
     * k   i       j
     * [-4,-1,-1,0,1,2]
     * 1. 先排序，这样确定最大和最小值
     * 2. 定义三个指针，k i j
     * 3. i在数组最左边，表示最小值。j在数组最右边，表示最大值。k表示第三个数，刚开始在最左边
     * 4. 如果连k都大于0，直接退出
     * 5. 跳过一下k重复的数据 nums[k] == nums[k-1]
     * 6. 如果i和j的和大于0，j--，因为j在右边，所以和肯定大于0，所以i++
     * 7. 如果i和j的和小于0，i++，因为i在左边，所以和肯定小于0，所以j--
     * 8. 如果i和j的和等于0，说明符合要求的结果，加入到结果集中，并且跳过重复的i和j
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < n - 2; k++) {
            // 跳过k重复的
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = n - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    // 跳过重复的
                    while (i < j && nums[i] == nums[++i]);
                }else if (sum > 0) {
                    // 跳过重复的
                    while (i < j && nums[j] == nums[--j]);
                }else {
                    // 符合要求的结果
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 继续跳过重复的
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
