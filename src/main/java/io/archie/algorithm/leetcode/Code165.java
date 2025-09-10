package io.archie.algorithm.leetcode;

/**
 * 比较版本号<br/> 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。 <br/> 比较版本号时，请按 从左到右的顺序
 * 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。 <br/> 返回规则如下： <br/> 如果 version1 < version2 返回 -1，<br/> 如果 version1 >
 * version2 返回 1，<br/> 除此之外返回 0。<br/>
 */
public class Code165 {

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.00001.1";
        System.out.println(new Code165().compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            int a = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                a = a * 10 + version1.charAt(i) - '0';
            }
            i++;
            int b = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                b = b * 10 + version2.charAt(j) - '0';
            }
            j++;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }
}
