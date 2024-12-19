package io.archie.algorithm.leetcodeClassic;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 13:05
 */
public class Code121 {

    public static void main(String[] args) {
        Code121 code121 = new Code121();
        
        int[] prices = {7,1,5,3,6,4};
        System.out.println(code121.maxProfit(prices));
    }

    /**
     * 我的思路：遍历一次，找到某天最小值和之后某天的最大值
     * 
     * 循环的时候，不断寻找最小值，如果找到了，就替换当前最小值
     * 在当前的最小值下，往后找最大值，不断替换最大值，找到最大利润。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}