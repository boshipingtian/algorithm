package io.archie.algorithm;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

//HJ33 整数与IP地址间的转换
//      10.0.3.193
//      167969729

public class CodeHJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String ip = in.nextLine();
            String[] ips = ip.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String ipItem : ips) {
                sb.append(toByte(ipItem, 8));
            }
            System.out.println(toInt(sb.toString()));
            String num = in.nextLine();
            String numIp = toByte(num, -1);
            if(numIp.length() % 8 != 0){
                for(int i=0; i < numIp.length() % 8; i++){
                    numIp = "0"+numIp;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            while(!"".equals(numIp)){
                String splitIp = numIp.substring(0, 8);
                numIp = numIp.substring(8);
                sb2.append(toInt(splitIp)).append(".");
            }
            sb2 = sb2.deleteCharAt(sb2.length()-1);
            System.out.println(sb2.toString());
        }
    }

    public static String toByte(String inta, int length) {
        long i = Long.parseLong(inta);
        Stack<Long> stack = new Stack<>();
        while (i != 1 && i != 0) {
            long a = i / 2;
            long b = i % 2;
            stack.add(b);
            i = a;
        }
        stack.add(i);
        StringBuilder sb = new StringBuilder();
        if (length != -1) {
            if (stack.size() < length) {
                for (int j = 0; j < length - stack.size(); j++) {
                    sb.append("0");
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String toInt(String byta) {
        long result = 0;
        for (int i = byta.length() - 1; i >= 0; i--) {
            result += Long.parseLong(String.valueOf(byta.charAt((byta.length() - 1) - i))) * Math.pow(2, i);
        }
        "1".contains("1");
        return String.valueOf(result);
    }
// 更好的方法
//    public static String toByte(String inta, int length) {
//        long l = Long.parseLong(inta);
//        String lb = Long.toBinaryString(l);
//        String format = "%s";
//        if(length !=-1){
//            format = "%" + length + "s";
//        }
//        return String.format(format, lb).replace(" ", "0");
//    }
//
//    public static String toInt(String byta) {
//        return String.valueOf(Long.parseLong(byta, 2));
//    }
}
