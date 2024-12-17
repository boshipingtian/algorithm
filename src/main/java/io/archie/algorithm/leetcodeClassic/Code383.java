package io.archie.algorithm.leetcodeClassic;

import java.util.HashMap;
import java.util.Map;

public class Code383 {

    public static void main(String[] args) {
        Code383 code383 = new Code383();

        String ransomNode1 = "aa";
        String magazine1 = "ab";
        System.out.println(code383.canConstructBetter(ransomNode1, magazine1));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) < 1) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }

    public boolean canConstructBetter(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (char c : magazine.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            hash[c - 'a']--;
        }
        for (int i : hash) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
