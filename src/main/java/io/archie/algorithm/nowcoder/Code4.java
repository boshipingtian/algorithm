package io.archie.algorithm.nowcoder;

import java.util.Scanner;

// HJ58 输入n个整数，输出其中最小的k个
public class Code4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int[] corner = {0, 0};
            String line = in.nextLine();
            String[] perStep = line.split(";");
            for (String str : perStep) {
                Integer step = check(str);
                if (step != null) {
                    move(str, step, corner);
                }
            }
            for(int i=0; i<corner.length; i++){
                System.out.print(i);
                if(i != corner.length) System.out.print(",");
            }
        }
    }

    public static void move(String action, int step, int[] corner) {
        String str = String.valueOf(action.charAt(0));
        switch (str) {
            case "W":
                corner[1] = corner[1] + step;
                break;
            case "A":
                corner[0] = corner[0] - step;
                break;
            case "S":
                corner[1] = corner[1] - step;
                break;
            case "D":
                corner[0] = corner[0] + step;
                break;
        }
    }

    public static Integer check(String action) {
        if(action == null || action.length() == 0) return null;
        char s = action.charAt(0);
        if (s == 'W' || s == 'A' || s == 'S' || s == 'D') {
            String numStr = action.substring(1);
            try {
                return Integer.parseInt(numStr);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
