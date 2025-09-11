package io.archie.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Code17 {

    public static void main(String[] args) {

        String t1 = "23456789";
        Code17 cOde17 = new Code17();
        System.out.println(cOde17.letterCombinations(t1));

    }

    static Map<Character, List<String>> map = new HashMap<>() {{
        put('1', List.of());
        put('2', List.of("a", "b", "c"));
        put('3', List.of("d", "e", "f"));
        put('4', List.of("g", "h", "i"));
        put('5', List.of("j", "k", "l"));
        put('6', List.of("m", "n", "o"));
        put('7', List.of("p", "q", "r", "s"));
        put('8', List.of("t", "u", "v"));
        put('9', List.of("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(combinations, map, digits, 0, sb);
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, List<String>> phoneMap, String digits, int index,
        StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            List<String> letters = phoneMap.get(digit);
            for (String letter : letters) {
                combination.append(letter);
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
