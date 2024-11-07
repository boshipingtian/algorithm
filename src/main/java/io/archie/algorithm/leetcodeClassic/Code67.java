package io.archie.algorithm.leetcodeClassic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;

        int max = Math.max(al, bl);
        int temp = 0;
        List<String> list = new ArrayList<>();
        for (int j = max; j >= 0; j--) {
            if (al >= 0 && bl >= 0) {
                int val1 = conver(a.charAt(al));
                int val2 = conver(b.charAt(bl));
                list.add((val1 + val2 + temp) % 2 + "");
                temp = (val1 + val2 + temp) / 2;
            } else if (al >= 0) {
                int val1 = conver(a.charAt(al));
                list.add((val1 + temp) % 2 + "");
                temp = (val1 + temp) / 2;
            } else if (bl >= 0) {
                int val2 = conver(b.charAt(bl));
                list.add((val2 + temp) % 2 + "");
                temp = (val2 + temp) / 2;
            }
            al--;
            bl--;
        }
        if (temp > 0) list.add(temp + "");
        Collections.reverse(list);
        return String.join("", list);
    }

    public static int conver(char c) {
        if ('1' == c) return 1;
        if ('0' == c) return 0;
        return -1;
    }
}
