package io.archie.algorithm.leetcode;


public class Code443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};

        System.out.println(compress(chars));
        System.out.println(chars);
    }

    public static int compress(char[] chars) {
        int write = 0, n = chars.length, left = 0;
        for (int read = 0; read < n; read++) {
            if(read == n-1 || chars[read+1] != chars[read]){
                chars[write++] = chars[read];
                int count = read - left + 1;
                if(count>1){
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                left = read+1;
            }
        }
        return write;
    }
}
