package com.practice.leetcode;

import java.util.*;

/**
 * Created by Ruchit.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(longestPalindromeSubseq(s.nextLine()));
    }


    public static int longestPalindromeSubseq(String s) {
        int[][] lps = new int[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            lps[i][i] = 1;
            for(int j=i+1; j < s.length(); j++){
                if(i+1 == j && s.charAt(i) == s.charAt(j)){
                    lps[i][j] = 2;
                }
                else if(i+1 <= j && s.charAt(i) == s.charAt(j)){
                    lps[i][j] = lps[i+1][j-1] + 2;
                }
                else{
                    lps[i][j] = Math.max(lps[i][j-1], lps[i+1][j]);
                }
            }
        }
        return lps[0][s.length()-1];
    }
}
