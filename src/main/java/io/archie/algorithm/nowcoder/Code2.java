package io.archie.algorithm.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            char[] array = line.toCharArray();
            Stack<Integer> stack = new Stack<>();
            Set<Integer> set = new HashSet<>();
            for (char c : array) {
                int i = Integer.parseInt(String.valueOf(c));
                stack.push(i);
            }
            while (!stack.isEmpty()){
                Integer pop = stack.pop();
                if(set.contains(pop)){
                    continue;
                }
                System.out.print(pop);
                set.add(pop);
            }

        }
    }
}
