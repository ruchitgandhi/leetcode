package com.practice.leetcode;

/**
 * Created by Ruchit on 06-01-2018.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfitWithStock = Integer.MIN_VALUE, maxProfitWithoutStock = 0, temp;

        for (int price : prices) {
            maxProfitWithoutStock = Math.max(maxProfitWithoutStock, maxProfitWithStock + price);
            maxProfitWithStock = Math.max(maxProfitWithStock, price * -1);
        }
        return maxProfitWithoutStock;
    }
}
