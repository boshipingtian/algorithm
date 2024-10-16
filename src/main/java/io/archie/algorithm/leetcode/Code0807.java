package io.archie.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合 <br> 
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1: 输入：S = "qwe" 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"] 
 * <p>
 * 示例2: 输入：S = "ab" 输出：["ab", "ba"] 提示:
 * <p>
 * 字符都是英文字母。 字符串长度在[1, 9]之间。
 *
 * @Author: MrArchie
 * @Date: 2024/9/26 16:28
 */
public class Code0807 {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        String[] res = permutation(s);
        for (String str : res) {
            System.out.println(str);
        }
    }
    
    public static String[] permutation(String S) {
        permute(S.toCharArray(), 0);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    public static void permute(char[] arr, int first) {
        if(first == arr.length-1) {
            list.add(new String(arr));
            return;
        }
        for(int i = first; i < arr.length; i++) {
            swap(arr, first, i);
            permute(arr, first + 1);
            swap(arr, first, i);
        }
    }
    
    public static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}