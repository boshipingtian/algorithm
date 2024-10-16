package io.archie.algorithm.leetcode;

import java.util.Arrays;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/13 17:10
 */
public class CodeLCP02 {

    public static void main(String[] args) {
        // 3 + 1 / (2 + 1 /(0 + 1/ 2)))
        int[] cont = {3, 2, 0, 2};
        // 2 + 0 / 1 
        // n = cont[i] * n + m;  n = m; 
        // m = 2 n = 1
        System.out.println(Arrays.toString(fraction(cont)));
    }


    public static int[] fraction(int[] cont) {
        int[] res = new int[2];
        // n 
        res[0] = 1;
        // m
        res[1] = 0;
        
        for (int i = cont.length-1; i>=0;i--){
            int temp = res[0];
            res[0] = cont[i] * res[0] + res[1];
            res[1] = temp;
        }
        return res;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static int[] fraction_answer(int[] cont) {
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 0;
        for (int i = cont.length - 1; i >= 0; i--) {
            int temp = res[1];
            res[1] = res[0];
            res[0] = cont[i] * res[1] + temp;
        }
        return res;
    }
}