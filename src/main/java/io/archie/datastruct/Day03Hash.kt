package io.archie.datastruct

/**
 * # 哈希表
 * 哈希表通过建立建key与值value之间的映射，实现高效查询（O(1)）
 *
 * ## 哈希冲突与扩容
 * 哈希函数本质上是将所有输入映射到优先的输出上，理论上一定存在多个输入对应相同数据的情况，这种情况称为哈希冲突。
 * 解决方法：
 * - 链式地址
 * - 开放寻址
 *
 * 哈希表扩容需要将所有键值迁移到新哈希表，非常耗时。因此编程语言通常会预留足够大的哈希表容量
 * 负载因子：哈希表数量除以桶数量，用来衡量哈希冲突的严重程度，也常作为哈希表扩容的触发条件。
 *
 * ### 链式地址
 * 转链表、AVL
 * ### 开放寻址
 * 开放寻址（线性探测、平方探测和多次哈希）哈希表都存在“不能直接删除元素”的问题
 *
 * - 线形探测：如果出现冲突，以固定步长向后探测。容易产生聚集现象，不能直接删除元素，
 * 会产生空桶，查询其他冲突key时会直接返回，因此用 TOMBSTONE 来标记，懒删除会加速哈希表性能退化。
 * 可以考虑记录首个TOMBSTONE索引与目标元素交换位置，每次查询会被移至理想位置（离探测点更近）
 *
 * - 平方探测：类似线形探测，但是以探测次数的平方作为步长
 * - 多次哈希：使用多个哈希函数f1，f2，如果f1出现冲突，则使用f2
 */
class Day03Hash {

    fun kotlinMap() {
        val map = HashMap<Int, String>()
        map.put(1, "apple")
        map.put(2, "banana")
        map.put(3, "orange")

        println(map)
        // 遍历键值对
        for ((key, value) in map) {
            println("$key -> $value")
        }

        // 单独遍历键
        for (key in map.keys) {
            println(key)
        }
        // 单独遍历值
        for (value in map.values) {
            println(value)
        }

        map.values.map { v ->
            println(v)
        }
    }
}