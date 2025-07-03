package io.archie.datastruct;

/**
 * # 列表
 * 列表是一种抽象的数据结构概念，表示元素的有序集合，支持元素访问、修改、添加、删除和遍历等操作，无需使用者考虑容量限制。
 * 列表可以基于链表或数组实现
 * - 链表天然可以看作一个列表，支持增删查改操作，并且可以灵活动态扩容
 * - 数组也支持元素增删查改，但是长度不可变，因此只能看作一个具有长度限制的列表
 * 为了解决此问题，可以使用动态数组来实现列表，它继承了数组的优点，并且可以在程序运行过程中动态扩容
 * - 许多语言标准库中的列表是基于动态数组实现的。
 */
class Day01List {

    /**
     * 初始化列表
     * 无值初始化
     */
    fun init(): List<Int> {
        return listOf()
    }

    /**
     * 初始化列表
     * 有值初始化
     */
    fun init(vararg v: Int): List<Int> {
        return v.toList()
    }

    /**
     * 访问元素
     * 在O(1)时间内访问和更新元素
     */
    fun find(list: MutableList<Int>, index: Int, value: Int? = null): Int {
        if (value != null) {
            list[index] = value
        }
        val i = list[index]
        return i
    }

    /**
     * 插入元素
     */
    fun insert(list: MutableList<Int>, index: Int, value: Int) {
        list.add(index, value)
    }

    /**
     * 删除元素
     */
    fun remove(list: MutableList<Int>, index: Int) {
        list.removeAt(index)
    }

    /**
     * 遍历列表
     */
    fun traverse(list: List<Int>) {
        for (i in list) {
            println(i)
        }
        for (i in list.indices) {
            println(list[i])
        }
    }

    /**
     * 拼接列表
     */
    fun concat(l1: List<Int>, l2: List<Int>): List<Int> {
        val list = l1.toMutableList()
        list.addAll(l2)
        return list
    }

    /**
     * 排序列表
     * 排序后元素大小从小到大排序
     */
    fun sort(list: List<Int>): List<Int> {
        return list.sorted()
    }

    /**
     * 自定义的简易列表
     * - 初始容量：选取合适的数组初始容量，这里选择10。
     * - 数量记录：声明一个变量size，用于记录列表当前元素数量，并随着元素插入和删除实时更新。根据此变量，可以定位列表尾部，判断是否需要扩容
     * - 扩容机制：若插入元素时列表容量已满，则需要扩容，根据扩容背书创建一个更大的数组，然后将当前数据的所有元素移至新数组。
     */
    class MyList {
        // 数组 存储列表元素
        private var arr: IntArray = intArrayOf()

        // 列表容量
        private var capacity: Int = 10

        //列表长度 当前元素数量
        private var size: Int = 0

        // 每次扩容的倍数
        private val extendRatio: Int = 2

        init {
            arr = IntArray(capacity)
        }

        /**
         * 获取列表长度 当前元素数量
         * @return [Int]
         */
        fun size(): Int {
            return size
        }

        /**
         * 获取列表容量
         * @return [Int]
         */
        fun capacity(): Int {
            return capacity
        }

        /**
         * 访问元素
         */
        fun get(index: Int): Int {
            if (index < 0 || index >= size) {
                throw IndexOutOfBoundsException("索引越界")
            }
            return arr[index]
        }

        /**
         * 更新元素
         */
        fun set(index: Int, value: Int) {
            if (index < 0 || index >= size) {
                throw IndexOutOfBoundsException("索引越界")
            }
            arr[index] = value
        }

        /**
         * 在尾部添加元素
         */
        fun add(value: Int) {
            // 如果元素数量超出容量，触发扩容机制
            if (size == capacity()) {
                extendCapacity()
            }
            arr[size] = value
            size++
        }

        /**
         * 在中间插入元素
         */
        fun insert(index: Int, value: Int) {
            if (index < 0 || index >= size) {
                throw IndexOutOfBoundsException("索引越界")
            }
            // 元素数量超出容量，触发扩容
            if (size == capacity()) {
                extendCapacity()
            }
            // 将index后的元素向后偏移1位
            for (i in size - 1 downTo index) {
                arr[i + 1] = arr[i]
            }
            arr[index] = value
            size++
        }

        /**
         * 删除元素
         */
        fun delete(index: Int): Int {
            // 判断索引
            if (index < 0 || index >= size) {
                throw IndexOutOfBoundsException("索引越界")
            }
            val value = arr[index]
            // 把index之后的元素向前移1位
            for (i in index..<size - 1) {
                arr[i] = arr[i + 1]
            }
            // 更新元素数量
            size--
            return value
        }

        /**
         * 列表扩容
         */
        fun extendCapacity() {
            // 新建一个长度为原数组extendRatio倍数的新数组
            arr = arr.copyOf(capacity() * extendRatio)
            // 更新列表容量
            capacity = arr.size
            println("触发扩容，当前容量${capacity}")
        }

        /**
         * 列表转为数组
         */
        fun toArray(): IntArray {
            val size = size()
            // 仅转换有效长度的列表元素
            val arr = IntArray(size)
            for (i in 0..<size) {
                arr[i] = get(i)
            }
            return arr
        }
    }
}
