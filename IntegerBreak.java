package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], (i-j > dp[i-j] ? i-j : dp[i-j]) * (j > dp[j] ? j : dp[j]));
            }
            System.out.println(i + " " + dp[i]);
        }
        return dp[n];
    }
}
