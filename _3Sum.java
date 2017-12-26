package com.practice.leetcode;

import java.util.*;
/**
 * Created by Ruchit.
 */
public class _3Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = {-1,0,1,2,-1,4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp, number, previous;
        boolean evaluated = false;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length-1; i++){
            if(i==0 || (nums[i] != nums[i-1])) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if(j==i+1 || (nums[j] != nums[j-1])){
                        evaluated = true;
                        number = 0 - (nums[i] + nums[j]);
                        if (map.get(number) != null && map.get(number) > j) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[map.get(number)]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
