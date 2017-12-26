package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(minimumDeleteSum(s1,s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int lenS1 = s1.length(), lenS2 = s2.length();
        int dp[][] = new int[lenS1+1][lenS2+1];

        for(int i=lenS1-1; i>=0; i--){
            dp[i][lenS2] = dp[i+1][lenS2] + s1.codePointAt(i);
        }

        for(int j=lenS2-1; j>=0; j--){
            dp[lenS1][j] = dp[lenS1][j+1] + s2.codePointAt(j);
        }

        for(int i=lenS1-1; i>=0; i--){
            for(int j=lenS2-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j+1] + s2.codePointAt(j), dp[i+1][j] + s1.codePointAt(i));
                }
            }
        }
        return dp[0][0];
    }
}
