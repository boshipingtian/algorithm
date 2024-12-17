package io.archie.algorithm.leetcodeClassic;

import java.util.Arrays;

public class Code14 {

    public static void main(String[] args) {
        Code14 code14 = new Code14();

        String[] strs1 = {"flower", "flow", "flight"};
        String ans1 = code14.longestCommonPrefix2(strs1);
        System.out.println("ans1 = " + ans1);
        String[] strs2 = {"dog", "racecar", "car"};
        String ans2 = code14.longestCommonPrefix2(strs2);
        System.out.println("ans2 = " + ans2);

        String[] strs3 = {"ab", "a"};
        String ans3 = code14.longestCommonPrefix2(strs3);
        System.out.println("ans3 = " + ans3);
    }

    public String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < n; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
