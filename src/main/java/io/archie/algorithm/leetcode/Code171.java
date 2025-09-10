package io.archie.algorithm.leetcode;

/**
 * 171. Excel 表列序号 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 例如：
 * <p>
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A" 输出: 1 示例 2:
 * <p>
 * 输入: columnTitle = "AB" 输出: 28 示例 3:
 * <p>
 * 输入: columnTitle = "ZY" 输出: 701
 * <p>
 * 输入: columnTitle = "FXSHRXW" 输出: 2147483647
 */
public class Code171 {

    public static void main(String[] args) {
        String a = "A";
        String b = "AB";
        String c = "ZY";
        String d = "FXSHRXW";
        Code171 code171 = new Code171();
        System.out.println(code171.titleToNumber(a));
        System.out.println(code171.titleToNumber(b));
        System.out.println(code171.titleToNumber(c));
        System.out.println(code171.titleToNumber(d));
    }

    /**
     * A = 1*26^0 AB = 1*26^1+2*26^0 ZY = 26*26^1+25*26^0
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for (int i = n; i > 0; i--) {
            res += (columnTitle.charAt(n - i) - 'A' + 1) * (int) Math.pow(26, i - 1);
        }
        return res;
    }

}
