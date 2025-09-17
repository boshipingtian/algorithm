package io.archie.algorithm.sort;

import io.archie.algorithm.helper.SortHelper;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 1, 5, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right){
        if (left >= right)
            return;
        // 哨兵划分
        int pivot = partition(arr, left, right);
        // 递归左子数组、右子数组
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            // 把大于中位数的挪到右边
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            // 把小于中位数的挪到左边
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            SortHelper.swap(i, j, arr);
        }
        SortHelper.swap(left, j, arr);
        return i;
    }
}
