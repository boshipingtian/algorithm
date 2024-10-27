package io.archie.algorithm.huawei.meet;

import java.util.Objects;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/21 19:31
 */
public class Code3 {

    public static void main(String[] args) {
        String test1 = "google";
        String test2 = "wellcome";
        String test3 = "abccbadef";
        System.out.println(getMaxLength(test1));
        System.out.println(getMaxLength(test2));
        System.out.println(getMaxLength(test3));
    }
    
    public static Integer getMaxLength(String str) {
        if(Objects.isNull(str) || str.isEmpty()){
            return -1;
        }
        int n = str.length();
        int maxLength = 1;
        int left = 0, right = 0;
        for (int i = 0; i < n-1; i++) {
            left = i;
            right = i+1;
            if(str.charAt(left) == str.charAt(right)){
                while(left >= 0 && right < n){
                    if(str.charAt(left) == str.charAt(right)){
                        maxLength = Math.max(maxLength, right - left + 1);
                        left--;
                        right++;
                    }else {
                        break;
                    }
                }
            }
        }
        return maxLength;
    }
}