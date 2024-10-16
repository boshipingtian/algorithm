package io.archie.algorithm;

import java.util.Stack;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/14 18:52
 */
public class Code2 {

    public static void main(String[] args) {
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[]}";
        System.out.println(checkSqua(test1));
        System.out.println(checkSqua(test2));
        System.out.println(checkSqua(test3));
        System.out.println(checkSqua(test4));
        System.out.println(checkSqua(test5));
        System.out.println(checkSqua("(("));
    }
    
    public static boolean checkSqua(String s){
        if("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(')' == c && '(' == stack.peek()){
                stack.pop();
            }else if(']' == c && '[' == stack.peek()){
                stack.pop();
            }else if('}' == c && '{' == stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
}