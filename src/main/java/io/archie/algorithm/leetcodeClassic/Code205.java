package io.archie.algorithm.leetcodeClassic;

import java.util.HashMap;
import java.util.Map;

public class Code205 {

    public static void main(String[] args) {
        Code205 code205 = new Code205();

        String s1 = "egg";
        String t1 = "add";
        System.out.println(code205.isIsomorphic(s1, t1));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(code205.isIsomorphic(s2, t2));
    }

    /**
     * 思路：设置两个哈希表
     *
     * 每遍历一次字符得到sChar,tChar，都检查一边自己的哈希表中是否存在对方的值
     * 比如在s的map中，是否窜在tChar，对应的value是sChar。
     * 如果是，
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sm = new HashMap<>();
        Map<Character, Character> tm = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((sm.containsKey(tc) && sm.get(tc) != sc) || (tm.containsKey(sc) && tm.get(sc) != tc)) {
                return false;
            }
            sm.put(tc, sc);
            tm.put(sc, tc);
        }
        return true;
    }
}
