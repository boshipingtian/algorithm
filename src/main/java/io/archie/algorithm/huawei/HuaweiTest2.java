package io.archie.algorithm.huawei;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HuaweiTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // 宽
            int x = in.nextInt();
            // 长
            int y = in.nextInt();
            // 电站边长
            int a = in.nextInt();
            // 最低电量
            int p = in.nextInt();

            int[][] position = new int[x][y];
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    position[i][j] = in.nextInt();
                }
            }
            
            // 构建数据
            int xa = 0,xb = a;
            int ya = 0,yb = a;
            // 一共有多少符合要求的
            int count = 0;
            while(true){
                if(yb > y){
                    xa++;xb++;
                    if(xb>x){
                        break;
                    }
                    ya =0; yb=a;
                }
                int total = 0;
                // 寻找四个点包含的区域总发电量
                for(int x1=xa;x1<xb;x1++){
                    for(int y1=ya;y1<yb;y1++){
                        total += position[x1][y1];
                    }
                }
                if(total >= p){
                    count++;
                }
                ya++;yb++;
            }
            System.out.println(count);
        }
    }
}