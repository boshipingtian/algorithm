package io.archie.algorithm.leetcodeClassic;

import java.util.ArrayList;
import java.util.List;

public class Code28_1 {

    public static void main(String[] args) {
        String haystack = "saddaddbutddadsad";
        String needle = "ddad";
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = new int[p.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 2, j = 0; i <= p.length; i++) {
            while (j > 0 && p[j] != p[i - 1]) {
                j = next[j];
            }
            if (p[i - 1] == p[j]) {
                j++;
            }
            next[i] = j;
        }
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
        System.out.println("res = " + res);
    }
}
