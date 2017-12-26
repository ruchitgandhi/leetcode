package com.practice.leetcode;

/**
 * Created by Ruchit.
 */
public class ContainerWithMostWater{
    public static void main(String[] args) {
        int[] height = {10,11,5,7,1,1,1,1,1,10};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int area,maxArea = 0;
        int i=0, j=height.length-1;
        while(i < j){
            area = (j-i)*Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}
