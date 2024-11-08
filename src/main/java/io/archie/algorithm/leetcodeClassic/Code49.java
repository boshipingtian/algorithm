package io.archie.algorithm.leetcodeClassic;

import java.util.*;

public class Code49 {

    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test1));
        System.out.println(groupAnagrams2(test1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> countMap = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> valMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                valMap.put(c, valMap.getOrDefault(c, 0)+1);
            }
            List<String> orDefault;
            if(countMap.containsKey(valMap)){
                orDefault = countMap.getOrDefault(valMap, new ArrayList<>());
            }else {
                orDefault = new ArrayList<>();
            }
            orDefault.add(s);
            countMap.put(valMap, orDefault);
        }
        return countMap.values().stream().toList();
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> countMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            List<String> list;
            String key = new String(charArray);
            if(countMap.containsKey(key)){
                list = countMap.get(key);
            }else {
                list = new ArrayList<>();
            }
            list.add(s);
            countMap.put(key, list);
        }
        return countMap.values().stream().toList();
    }
}
