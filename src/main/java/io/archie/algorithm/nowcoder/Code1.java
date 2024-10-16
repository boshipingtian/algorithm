package io.archie.algorithm.nowcoder;

import java.util.*;

public class Code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            double v = sc.nextDouble();
            System.out.println((int)(v+0.5));
        }
    }
}
