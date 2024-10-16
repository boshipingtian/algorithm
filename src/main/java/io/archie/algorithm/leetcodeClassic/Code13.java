package io.archie.algorithm.leetcodeClassic;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值 I             1 V             5 X             10 L             50 C             100 D             500
 * M             1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为
 * IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和
 * 900。 给定一个罗马数字，将其转换成整数。
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 12:40
 */
public class Code13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("IVII"));
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int point = 0;
        int value = 0;
        while (point < chars.length) {
            char c = chars[point];
            switch (c) {
                case 'I':
                    if (point + 1 < n && chars[point + 1] == 'V') {
                        value += 4;
                        point++;
                    } else if (point + 1 < n && chars[point + 1] == 'X') {
                        value += 9;
                        point++;
                    } else {
                        value += 1;
                    }
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    if (point + 1 < n && chars[point + 1] == 'L') {
                        value += 40;
                        point++;
                    } else if (point + 1 < n && chars[point + 1] == 'C') {
                        value += 90;
                        point++;
                    } else {
                        value += 10;
                    }
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'C':
                    if (point + 1 < n && chars[point + 1] == 'D') {
                        value += 400;
                        point++;
                    } else if (point + 1 < n && chars[point + 1] == 'M') {
                        value += 900;
                        point++;
                    } else {
                        value += 100;
                    }
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'M':
                    value += 1000;
                    break;
            }
            point++;
        }
        return value;
    }


}