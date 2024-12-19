package io.archie.algorithm.leetcodeClassic;

import java.util.HashSet;
import java.util.Set;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 13:26
 */
public class Code3 {

    public static void main(String[] args) {
        Code3 code3 = new Code3();

        String s = "abcabcbb";
        System.out.println(code3.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            while (l < r && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, r - l + 1);
            set.add(s.charAt(r));
        }
        return max;
    }

}