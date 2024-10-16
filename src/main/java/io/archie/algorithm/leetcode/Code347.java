package io.archie.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/13 16:13
 */
public class Code347 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
        System.out.println(Arrays.toString(topKFrequentBigHeap(nums, 2)));
    }


    /**
     * top key 普通解法
     *
     * @param nums 数组
     * @param k    k
     * @return {@link int[]}
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 1)+1);
        }
        int[] res = new int[k];
        List<Integer> list = map.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
            .limit(k).map(Entry::getKey).toList();
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * top key的最大堆解法
     *
     * @param nums 数组
     * @param k    k
     * @return {@link int[]}
     */
    public static int[] topKFrequentBigHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((a, b) -> map.get(a) - map.get(b)));

        for (Integer key : map.keySet()) {
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else if(map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        int[] res = new int[k];
        int i=0;
        while (!priorityQueue.isEmpty()){
            res[i++] = priorityQueue.remove();
        }
       return res;
    }

}