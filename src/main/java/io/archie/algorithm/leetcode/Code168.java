package io.archie.algorithm.leetcode;

/**
 * 168. Excel 表列名称 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 例如：
 * <p>
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * <p>
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1 输出："A" 示例 2：
 * <p>
 * 输入：columnNumber = 28 输出："AB" 示例 3：
 * <p>
 * 输入：columnNumber = 701 输出："ZY" 示例 4：
 * <p>
 * 输入：columnNumber = 2147483647 输出："FXSHRXW" abcdefghijklmnopqrstuvwxyz
 */
public class Code168 {

    public static void main(String[] args) {
        Code168 code168 = new Code168();
        System.out.println(code168.convertToTitle(1));
        System.out.println(code168.convertToTitle(28));
        System.out.println(code168.convertToTitle(701));
        System.out.println(code168.convertToTitle(2147483647));
    }

    /**
     * AB -> 28 1*26+2
     * <p>
     * ZY -> 701 26*26+25
     * <p>
     * 2147483647/26 = 82595524 ... 23 82595524/26 = 3176750 ... 24 3176750/26 = 122,182 ... 18 122,182 / 26 = 4,699 ...
     * 8
     *
     */
    public String convertToTitle(int columnNumber) {
        // 转ABC的26进制
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
