package io.archie.algorithm.sort;

import io.archie.algorithm.helper.SortHelper;
import java.util.Arrays;

public class SelectionSort {

    /**
     * 每次循环寻找数组中比队头小的元素，然后交换，最后一个元素为最大元素，不需要排序
     */
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 4, 5};
        int n = arr.length;
        // 外层循环不需要循环到最后
        for (int i = 0; i < n - 1; i++) {
            // 内层循环寻找比外层最小的元素
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            SortHelper.swap(i, min, arr);
        }
        System.out.println(Arrays.toString(arr));
    }

}
