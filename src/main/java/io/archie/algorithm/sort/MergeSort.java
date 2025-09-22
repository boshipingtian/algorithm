package io.archie.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 6, 0, 1, 5, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        // 终止条件
        if (left >= right) {
            return; // 当数组长度为1时，终止递归
        }
        // 划分阶段
        int mid = left + (right - left) / 2; // 计算中点
        mergeSort(arr, left, mid); // 递归左子树组
        mergeSort(arr, mid + 1, right); // 递归右子数组
        // 合并阶段
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 左子数组区间为[left, mid], 右子数组区间为[mid+1, right]
        // 创建一个临时数组temp，用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引。合并两个有序数组
        int i = left, j = mid + 1, k = 0;
        // 当左、右数组都还有元素时，进行比较并将较小的元素复制到临时数组
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把剩余元素复制到临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将临时数组复制回原数组
        for (k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }

}
