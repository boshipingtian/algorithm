package io.archie.algorithm;

import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class CodeHJ23 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getValue);
    }
}
