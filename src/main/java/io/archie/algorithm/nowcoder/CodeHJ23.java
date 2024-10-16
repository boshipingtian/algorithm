package io.archie.algorithm.nowcoder;

import java.util.HashMap;
import java.util.*;

public class CodeHJ23 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getValue);
    }
}
