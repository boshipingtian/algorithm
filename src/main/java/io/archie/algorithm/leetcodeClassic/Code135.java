package io.archie.algorithm.leetcodeClassic;

public class Code135 {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int right = 0;
        int count = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (j < n - 1 && ratings[j] > ratings[j + 1]) {
                right++;
            } else {
                right = 1;
            }
            count += Math.max(right, candies[j]);
        }
        return count;
    }

    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int dec = 0;
        int inc = 1;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        // System.out.println(candy(ratings));
        System.out.println(candy2(ratings));
    }
}
