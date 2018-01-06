package com.practice.leetcode;

/**
 * Created by Ruchit on 06-01-2018.
 */
public class BestTimeToBuyAndSellStock_II {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int previousWithStock = Integer.MIN_VALUE, previousWithoutStock = 0, temp;

        for (int price : prices) {
            temp = previousWithStock;
            previousWithStock = Math.max(previousWithStock, previousWithoutStock - price);
            previousWithoutStock = Math.max(previousWithoutStock, temp + price);
        }
        return previousWithoutStock;
    }
}
