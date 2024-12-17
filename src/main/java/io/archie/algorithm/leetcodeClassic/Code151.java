package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;

/**
 * 151. 反转字符串中的单词
 */
public class Code151 {

    public static void main(String[] args) {
        Code151 code151 = new Code151();

        String s1 = "the sky is blue";
        String ans1 = code151.reverseWordsDoublePoint(s1);
        System.out.println("ans1 = " + ans1);
        String s2 = "  hello world  ";
        String ans2 = code151.reverseWordsDoublePoint(s2);
        System.out.println("ans2 = " + ans2);
        String s3 = "a good   example";
        String ans3 = code151.reverseWordsDoublePoint(s3);
        System.out.println("ans3 = " + ans3);
    }

    public String reverseWords(String s) {
        String[] split = Arrays.stream(s.trim().split(" "))
                .filter(s1 -> !"".equals(s1)).toArray(String[]::new);
        int left = 0;
        int right = split.length - 1;
        while (left <= right) {
            String s1 = split[left];
            split[left] = split[right];
            split[right] = s1;
            left++;
            right--;
        }
        return String.join(" ", split);
    }

    public String reverseWordsDoublePoint(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = len - 1;
        int j = len - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
