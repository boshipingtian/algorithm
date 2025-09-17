package io.archie.algorithm.helper;

public class SortHelper {

    public static void swap(int i, int j, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
