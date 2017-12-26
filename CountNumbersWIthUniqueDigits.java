package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class CountNumbersWIthUniqueDigits {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countNumbersWithUniqueDigits(n));
        n = 3;
        System.out.println(countNumbersWithUniqueDigits(n));
        n = 1;
        System.out.println(countNumbersWithUniqueDigits(n));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n>10){
            return 0;
        }
        else if(n==0){
            return 1;
        }
        else {
            int dp[] = new int[n + 1];
            int result = 0;
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                if(i==2){
                    dp[2] =(dp[1] * 9) - 9;
                }
                else {
                    dp[i] = dp[i - 1] * (10 - i + 1);
                }
                result += dp[i];
            }
            return result;
        }
    }
}
