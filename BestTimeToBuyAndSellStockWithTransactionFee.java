package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        long previousWithStock = Integer.MIN_VALUE, previousWithoutStock = 0, temp;

        for (int price : prices) {
            temp = previousWithStock;
            previousWithStock = Math.max(previousWithStock, previousWithoutStock - price);
            previousWithoutStock = Math.max(previousWithoutStock, temp + price - fee);
        }
        return (int) previousWithoutStock;
    }
}
