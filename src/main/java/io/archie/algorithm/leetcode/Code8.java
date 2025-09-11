package io.archie.algorithm.leetcode;

/**
 * 字符串取整， atoi 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 空格：读入字符串并丢弃无用的前导空格（" "） 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1]
 * ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。 返回整数作为最终结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "42"
 * <p>
 * 输出：42
 * <p>
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * <p>
 * 带下划线线的字符是所读的内容，插入符号是当前读入位置。 第 1 步："42"（当前没有读入字符，因为没有前导空格） ^ 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'） ^ 第 3 步："42"（读入
 * "42"） ^ 示例 2：
 * <p>
 * 输入：s = " -042"
 * <p>
 * 输出：-42
 * <p>
 * 解释：
 * <p>
 * 第 1 步："   -042"（读入前导空格，但忽视掉） ^ 第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数） ^ 第 3 步："   -042"（读入 "042"，在结果中忽略前导零） ^ 示例 3：
 * <p>
 * 输入：s = "1337c0d3"
 * <p>
 * 输出：1337
 * <p>
 * 解释：
 * <p>
 * 第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格） ^ 第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'） ^ 第 3 步："1337c0d3"（读入
 * "1337"；由于下一个字符不是一个数字，所以读入停止） ^ 示例 4：
 * <p>
 * 输入：s = "0-1"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 第 1 步："0-1" (当前没有读入字符，因为没有前导空格) ^ 第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+') ^ 第 3 步："0-1" (读入
 * "0"；由于下一个字符不是一个数字，所以读入停止) ^ 示例 5：
 * <p>
 * 输入：s = "words and 987"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 读取在第一个非数字字符“w”处停止。
 */
public class Code8 {

    public static void main(String[] args) {
        String t1 = "42"; // 42
        String t2 = "-042"; // -42
        String t3 = "1337c0d3"; // 1337
        String t4 = " 0-1"; // 0
        String t5 = "words and 987"; // 0
        String t6 = "-91283472332"; // 0
        String t7 = "9223372036854775808"; // 0

        Code8 code8 = new Code8();
        System.out.println(code8.myAtoi(t1));
        System.out.println(code8.myAtoi(t2));
        System.out.println(code8.myAtoi(t3));
        System.out.println(code8.myAtoi(t4));
        System.out.println(code8.myAtoi(t5));
        System.out.println(code8.myAtoi(t6));
        System.out.println(code8.myAtoi(t7));
    }

    public int myAtoiError(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int flag = 1;
        long res = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            // 丢弃无用空格
            if (s.charAt(i) == ' ') {
                continue;
            }
            break;
        }
        if (i >= s.length()) {
            return 0;
        }
        // 判断一下第一位包不包含符号
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        for (; i < s.length(); i++) {
            // 读取数字
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            // 跳过前置0读取数字
            res = res * 10 + (s.charAt(i) - '0');
        }
        // 超过-2^31 || 2^31-1 则舍去
        return round(flag * res);
    }


    private int round(long a) {
        if (a < Integer.MIN_VALUE || a > Integer.MAX_VALUE) {
            return a < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) a;
    }

    public int myAtoi2(String s) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = s.length();
        if (length == 0) {
            return 0;
        }
        while (s.charAt(i) == ' ') {
            if (++i == length) {
                return 0;
            }
        }
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < length; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                break;
            }
            if (res > bndry || res == bndry && s.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(j) - '0');
        }
        return sign * res;
    }

    public int myAtoi(String s) {
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, n = s.length();
        if (n == 0) {
            return res;
        }
        while (s.charAt(i) == ' ') {
            if (++i == n) {
                return res;
            }
        }
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        for (; i < n; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            if (res > max || (res == max && s.charAt(i) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }

}
