package io.archie.algorithm.leetcodeClassic;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/17 19:10
 */
public class Code125 {

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";

        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));
    }

    public static boolean isPalindrome(String s) {
        // 使用正则表达式匹配所有非字母数字字符，并替换为空字符串
        String cleanedText = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(cleanedText);
        int left = 0, right = cleanedText.length() - 1;
        while (left < right) {
            if(cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}