package io.archie.algorithm.leetcode;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/13 17:26
 */
public class Code14 {

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int right = 0;
        boolean has = false;
        if ("".equals(strs[0])) {
            return "";
        }
        while (right < strs[0].length()) {
            if (has) {
                break;
            }
            char c = strs[0].charAt(right);
            for (String str : strs) {
                if (str.length() <= right || str.charAt(right) != c) {
                    has = true;
                    right--;
                    break;
                }
            }
            right++;
        }
        return strs[0].substring(0, right);

    }
}