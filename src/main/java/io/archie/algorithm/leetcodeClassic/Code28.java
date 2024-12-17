package io.archie.algorithm.leetcodeClassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 找出字符串第一个匹配项的下标
 * <p>
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Code28 {

    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        Code28 code28 = new Code28();
        System.out.println(code28.strStr1(haystack, needle));

        int[] next1 = code28.genNext("abacb");
        System.out.println(Arrays.toString(next1));
        int[] next2 = code28.genNext2("abacb".toCharArray());
        System.out.println(Arrays.toString(next2));

        // kmp写法
        List<Integer> integers = code28.strStrKmp("abacb", "ac");
        System.out.println("integers = " + integers);
    }

    /**
     * 时间复杂度O((m-n)*n) 空间复杂度O(1)
     */
    public int strStr1(String haystack, String needle) {
        if (Objects.equals(haystack, needle)) {
            return 0;
        }
        int a = 0;
        int b = 0;
        while (b <= haystack.length() - needle.length()) {
            int tempB = b;
            while (a < needle.length()) {
                if (needle.charAt(a) == haystack.charAt(tempB)) {
                    a++;
                    tempB++;
                } else {
                    b++;
                    a = 0;
                    break;
                }
            }
            if (a == needle.length()) {
                break;
            }
        }
        return a == needle.length() ? b : -1;
    }

    /**
     * O(n^2)求法，两层循环
     *
     * @param p 字串
     * @return next数组
     */
    public int[] genNext(String p) {
        int n = p.length();
        int[] next = new int[n + 1];
        for (int j = 2; j <= n; j++) { // 遍历p的所有子串
            String tmp = p.substring(0, j); // p的字串
            // 因为找的最大公共前后缀，所以让前后缀长度从大到小遍历
            // 找到的第一个相等的前后缀长度len，就是next[j]的值
            for (int len = j - 1; len >= 1; len--) {
                if (tmp.substring(0, len).equals(tmp.substring(j - len, j))) {
                    next[j] = len;
                    break;
                }
            }
        }
        return next;
    }

    public int[] genNext2(char[] p) {
        int n = p.length;
        int[] next = new int[n + 1];
        for (int j = 2, i = 0; j <= n; j++) {
            while (i > 0 && p[i] != p[j - 1]) {
                i = next[i];
            }
            if (p[i] == p[j - 1]) {
                i++;
            }
            next[j] = i;
        }
        return next;
    }


    /**
     * 使用kmp算法完成
     * <p>
     * KMP算法是快速查找匹配串的算法，本质是如何快速在【原字符串】找到【匹配字符串】
     * 相比上面的解法O(m*n)，KMP算法复杂度在O(m+n)
     */
    public List<Integer> strStrKmp(String haystack, String needle) {
        List<Integer> res = new ArrayList<>();
        int[] next = this.genNext2(needle.toCharArray());
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        for (int i = 0, j = 0; i < s.length; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                res.add(i - j + 1);
                j = next[j];
            }
        }
        return res;
    }

}
