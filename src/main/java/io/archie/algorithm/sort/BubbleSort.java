package io.archie.algorithm.sort;

import io.archie.algorithm.helper.SortHelper;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 4, 5};
        int n = arr.length;
        // 外层每次循环都会把数组中最大的浮动到最后，就像气泡一样
        // 第二次执行只需要循环n-i次，i=0
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortHelper.swap(j, j + 1, arr);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
