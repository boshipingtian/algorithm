package io.archie.algorithm.leetcode;

class CompareVersionNumbers {


    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {

        public int compareVersion(String version1, String version2) {
            int n = version1.length(), m = version2.length();
            int i = 0, j = 0;
            while (i < n || j < m) {
                int x = 0;
                for (; i < n && version1.charAt(i) != '.'; i++) {
                    x = x * 10 + version1.charAt(i) - '0';
                }
                ++i; // 跳过.
                int y = 0;
                for (; j < m && version2.charAt(j) != '.'; j++) {
                    y = y * 10 + version2.charAt(j) - '0';
                }
                ++j; // 跳过.
                if (x != y) {
                    return x > y ? 1 : -1;
                }
            }
            return 0;
        }
    }
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        String version1 = "1.0";
        String version2 = "1.0.0.0";
        System.out.println(new CompareVersionNumbers().new Solution().compareVersion(version1, version2));
    }
}