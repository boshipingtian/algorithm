package io.archie.datastruct

import java.util.Stack

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        println(123)
        print(recur(2))
    }
}

// 递归
fun recur(n: Int): Int {
    if (n == 1) {
        return 1
    }
    val res = recur(n - 1)
    return res + n
}

// recursion尾递归
tailrec fun recursion(n: Int, res: Int): Int {
    // 终止条件
    if (n == 0) {
        return res;
    }
    return recursion(n - 1, res + n);
}

// 递归树
// 斐波那契数列
fun fib(n: Int): Int {
    // 终止条件 f(1) = 0 f(2) = 1
    if (n == 1 || n == 2) {
        return n - 1
    }
    // f(n) = f(n-1) + f(n-2)
    val res = fib(n - 1) + fib(n - 2)
    // 返回 f(n)
    return res
}

// 模拟调用栈
fun forLoopRecur(n: Int): Int {
    // 定义一个栈
    val stack = Stack<Int>()
    var res = 0;
    // 递：递归调用
    for (i in n downTo 0) {
        stack.push(i)
    }
    // 归：返回结果
    while (stack.isNotEmpty()) {
        // 出栈操作模拟归
        res += stack.pop()
    }
    // 返回结果 1+2+3
    return res
}