package io.archie.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 1, 5, 2};
        // 插入排序
        // 第一个元素是排好序的
        // 第二个元素作为基准 往前插入
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 基准元素
            int base = arr[i];
            // 已排序区间 [0, j-1]
            int j = i - 1;
            // 内循环，将base插入到[0,j-1]中的正确位置
            while (j >= 0 && arr[j] > base) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = base;
        }
        System.out.println(Arrays.toString(arr));
    }
}
