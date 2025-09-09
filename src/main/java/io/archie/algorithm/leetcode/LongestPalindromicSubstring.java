package io.archie.algorithm.leetcode;

class LongestPalindromicSubstring {


    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int n = s.length();
            int maxStart = 0; // 最长回文串起点
            int maxEnd = 0; // 最长回文串终点
            int maxLen = 1; // 最长回文串长度
            boolean[][] dp = new boolean[n][n];

            for (int r = 0; r < n; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            maxStart = l;
                            maxEnd = r;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        String s1 = "babad";
        String s2 = "cbbbbbbbbd";

        System.out.println(new LongestPalindromicSubstring().new Solution().longestPalindrome(s1));
        System.out.println(new LongestPalindromicSubstring().new Solution().longestPalindrome(s2));
    }
}