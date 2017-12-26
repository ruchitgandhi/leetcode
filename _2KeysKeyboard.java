package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class _2KeysKeyboard {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(minSteps(n));
    }

    public static int minSteps(int n) {
        int ans = 0;
        for(int i=2; i<=n; i++){
            while(n%i == 0){
                ans += i;
                n = n/i;
            }
        }
        return ans;
    }
}
