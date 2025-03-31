package io.archie.algorithm.test;

/**
 * 使用递归完成 字符串反转功能
 */
public class ForUCode1 {

    public static void main(String[] args) {
        String val1 = "abcd";
        System.out.println(val1 + " -> " + reverse(val1));
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        reverseFunc(chars, 0, sb);
        return sb.toString();
    }

    private static void reverseFunc(char[] val, int i, StringBuilder sb) {
        int n = val.length;
        if (i == n - 1) {
            sb.append(val[i]);
        } else {
            reverseFunc(val, i + 1, sb);
            sb.append(val[i]);
        }
    }

}
