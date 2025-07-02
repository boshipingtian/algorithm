package io.archie.datastruct

import java.util.concurrent.ThreadLocalRandom

/**
 * 数组的典型应用
 * - 随机访问
 * - 排序与搜索
 * - 查找表
 * - 机器学习
 * - 数据结构实现
 */
class Day01Array {

    /**
     * 随机访问元素
     */
    fun randomAccess() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        // 随机取一个数字
        val randomIndex = ThreadLocalRandom.current().nextInt(0, nums.size)
        val randomVal = nums[randomIndex]
        println(randomVal)
    }

    /**
     * 插入元素
     */
    fun insert(nums: IntArray, num: Int, index: Int) {
        for (i in nums.size - 1 downTo index + 1) {
            nums[i] = nums[i - 1]
        }
        nums[index] = num
    }

    /**
     * 删除元素
     */
    fun remove(nums: IntArray, index: Int) {
        // 索引index之后的元素前移一位
        for (i in index..<nums.size - 1) {
            nums[i] = nums[i + 1]
        }
    }

    /**
     * 查找元素
     */
    fun find(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (nums[i] == target) {
                return i
            }
        }
        return -1
    }

    /**
     * 扩容数组
     */
    fun extend(nums: IntArray, enlarge: Int): IntArray {
        val res = IntArray(nums.size + enlarge)
        for (i in nums.indices) {
            res[i] = nums[i]
        }
        return res
    }
}