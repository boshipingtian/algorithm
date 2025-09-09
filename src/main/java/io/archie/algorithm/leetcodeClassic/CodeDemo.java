package io.archie.algorithm.leetcodeClassic;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CodeDemo {

    public static void main(String[] args) {
        int a = 8 >> 1;
        int b = 8 >>> 1;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(1);
        map.put("1", "2");

        HashMap<String, String> map1 = new HashMap<>(10);
        map1.put("1", "2");
        System.out.println(Integer.numberOfLeadingZeros(1));
        int n = (-1 >>> Integer.numberOfLeadingZeros(1)) + 1;
        System.out.println("n = " + n);
    }

}
