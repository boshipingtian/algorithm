package io.archie.algorithm.leetcodeClassic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Code12 {

    public static void main(String[] args) {
        Code12 code12 = new Code12();

        int num1 = 3749;
        String roman1 = code12.intToRoman(num1);
        System.out.println("roman1 = " + roman1);

        String roman2 = code12.intToRomanBetter(num1);
        System.out.println("roman2 = " + roman2);
    }

    /**
     * 我的思路：
     * 3749
     * 直接从做高位开始除
     * 3749 / 1000 = 3...749 MMM
     * 749 / 500 = 1...249 D
     * 249 / 100 = 2...49 CC
     * 49 / 40 = 1...9 XL
     * 9 / 9 = 1...0 IX
     */
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(900);
        list.add(500);
        list.add(400);
        list.add(100);
        list.add(90);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(1);

        int temp = num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer it = list.get(i);
            if (temp >= it) {
                int replace = temp / it;
                for (int j = 0; j < replace; j++) {
                    sb.append(map.get(it));
                }
                temp = temp % it;
                if (temp == 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String intToRomanBetter(int num) {
        int x = num;
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            if (x >= 1000) {
                sb.append("M");
                x -= 1000;
            } else if (x >= 900) {
                sb.append("CM");
                x -= 900;
            } else if (x >= 500) {
                sb.append("D");
                x -= 500;
            } else if (x >= 400) {
                sb.append("CD");
                x -= 400;
            } else if (x >= 100) {
                sb.append("C");
                x -= 100;
            } else if (x >= 90) {
                sb.append("XC");
                x -= 90;
            } else if (x >= 50) {
                sb.append("L");
                x -= 50;
            } else if (x >= 40) {
                sb.append("XL");
                x -= 40;
            } else if (x >= 10) {
                sb.append("X");
                x -= 10;
            } else if (x >= 9) {
                sb.append("IX");
                x -= 9;
            } else if (x >= 5) {
                sb.append("V");
                x -= 5;
            } else if (x >= 4) {
                sb.append("IV");
                x -= 4;
            } else if (x >= 1) {
                sb.append("I");
                x -= 1;
            }
        }
        return sb.toString();
    }
}
