package com.practice.leetcode;

import java.util.Arrays;

/**
 * Created by Ruchit.
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        //int pairs[][] = {{1,2}, {2,3}, {3,4}};
        int pairs[][] = {{1,2}, {3,4}, {2,3}};
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> (a[0] - b[0]));
        int dp[] = new int[pairs.length];

        dp[0] = 1;
        for(int i=0; i<pairs.length; i++){
            for(int j=0; j<i; j++){
                dp[i] = Math.max(dp[i], pairs[j][1] < pairs[i][0] ? dp[j] + 1 : dp[j]);
            }
        }

        return dp[pairs.length - 1];
    }
}
