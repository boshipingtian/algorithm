package io.archie.algorithm.leetcodeClassic;

import java.util.HashSet;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/11 12:20
 */
public class Code380 {

    private final HashSet<Integer> set;

    public Code380() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        Integer[] array = this.set.toArray(new Integer[set.size()]);
        return array[(int) (Math.random() * array.length)];
    }
    
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}