package io.archie.algorithm;

import java.util.*;

public class Code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            String number = in.nextLine();
            int num = Integer.parseInt(number);
            for (int i = 0; i < num; i++) {
                System.out.print(line.charAt(i));
            }
        }
    }
}
