package com.practice.leetcode;

import java.util.Arrays;

/**
 * Created by Ruchit.
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        //int nums[] = {3,4,2};
        //int nums[] = {2,2,3,3,3,4};
        int nums[] = {1,2,2,3,3,3,4};
        //int nums[] = {3,1};
        //int nums[] = {15,20};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        if(nums.length > 0) {
            int totalValue[] = new int[10001];
            Arrays.sort(nums);

            for(int i=0; i<nums.length; i++){
                totalValue[nums[i]]+=nums[i];
            }

            int avoidTakingPrevious = 0;
            int takePrevious = 0, value;
            for(int i=0; i<10000; i++){
                value = totalValue[i] + avoidTakingPrevious;
                avoidTakingPrevious = Math.max(avoidTakingPrevious, takePrevious);
                takePrevious = value;
            }
            return Math.max(avoidTakingPrevious, takePrevious);
        }
        return 0;
    }
}
