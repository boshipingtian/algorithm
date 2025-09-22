package io.archie.algorithm.sort;

import io.archie.algorithm.helper.SortHelper;
import java.util.Arrays;

/**
 * 堆排序
 * 基于堆数据结构实现的高效排序算法。利用建堆和元素出堆实现堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1, 1, 2};
        // 1. 输入数组并建立大顶堆
        // 2. 将堆顶元素（第一个元素）与堆底元素（最后一个元素）交换，完成交换后，堆长度减1，已排序元素加1.
        // 3. 从堆顶元素开始，从顶到底执行堆化操作
        // 4. 循环执行第2、3步，循环n-1轮后，完成数组排序
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 建堆操作：堆化除叶子节点以外的其他所有节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, arr.length, i);
        }
        // 从堆中提取最大元素，循环n-1轮
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换根节点与最右叶子节点（交换首尾元素）
            SortHelper.swap(i, 0, arr);
            // 以根节点为起点，从顶至底进行堆化
            siftDown(arr, i, 0);
        }
    }

    // 堆的长度为n，从节点i开始，从顶至底堆化
    private static void siftDown(int[] arr, int n, int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l < n && arr[l] > arr[ma]) {
                ma = l;
            }
            if (r < n && arr[r] > arr[ma]) {
                ma = r;
            }
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i) {
                break;
            }
            // 交换两节点
            SortHelper.swap(ma, i, arr);
            // 循环向下堆化
            i = ma;
        }
    }
}
