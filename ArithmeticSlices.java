package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6,7,8};
        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int numOfSlices = 0;
        if(A.length>2) {
            int diff = A[1] - A[0];
            int low = 0;
            for (int i = 2; i < A.length; i++) {
                if (A[i] - A[i - 1] != diff) {
                    low = i - 1;
                    diff = A[i] - A[i - 1];
                } else {
                    numOfSlices += i - low - 1;
                }
            }
        }
        return numOfSlices;
    }
}
