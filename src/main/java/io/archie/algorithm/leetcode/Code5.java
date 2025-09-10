package io.archie.algorithm.leetcode;

/**
 * 最长回文子串
 */
public class Code5 {

    public static void main(String[] args) {
        String t1 = "ac";
        String t2 = "cbbbbbd";
        Code5 code5 = new Code5();
        System.out.println(code5.longestPalindrome(t1));
        System.out.println(code5.longestPalindrome(t2));
        System.out.println(code5.longestPalindrome2(t1));
        System.out.println(code5.longestPalindrome2(t2));
    }

    /**
     * 思路：中间往两边扩展。直到扩展到最大值
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 1;
        int start = -1;
        for (int i = 0; i < n; i++) {
            l = i - 1;
            r = i + 1;
            // 往左
            int tmpLen = 1;
            while (l >= 0 && s.charAt(l) == s.charAt(i)) {
                l--;
                tmpLen++;
            }
            // 往右
            while (r < n && s.charAt(r) == s.charAt(i)) {
                r++;
                tmpLen++;
            }
            // 往两边
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                tmpLen += 2;
            }
            if (maxLen < tmpLen) {
                maxLen = tmpLen;
                start = l;
            }
        }
        return s.substring(start + 1, start + maxLen + 1);
    }

    /**
     * 思路：动态规划 要判断dp[l-1][r+1]是否是回文，只要判断dp[l][r] = true && s.charAt(l-1) == s.charAt(r+1)即可 dp[0][0] = true; dp[i][i] =
     * true
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int start = 0;
        int maxLen = 1;
        for (int r = 0; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start, maxLen + start);
    }


}
