package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class PredictTheWinner {
    public static void main(String[] args) {
        //int nums[] = {1, 5, 2};
        int nums[] = {1, 5, 233, 7};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return calculateScoreDifference(nums, 0, nums.length-1) >= 0 ? true : false;
    }

    public static int calculateScoreDifference(int[] nums, int start, int end){
        if(start==end){
            return nums[start];
        }
        else if(start==end-1){
            return Math.max(nums[start] - nums[end], nums[end] - nums[start]);
        }
        else{
            return Math.max(nums[start] - calculateScoreDifference(nums, start+1, end),
                    nums[end] - calculateScoreDifference(nums, start, end-1));
        }
    }
}
