package com.practice.leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(s.nextLine()));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> record = new HashMap<>();
        int temp, length = 0, maxLength = 0;
        int startingIndex = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(record.get(s.charAt(i)) != null && record.get(s.charAt(i)) >= startingIndex)
            {
                temp = record.get(s.charAt(i));
                if(length > maxLength)
                {
                    maxLength = length;
                }
                length = length - (temp - startingIndex);
                startingIndex = temp + 1;
                record.put(s.charAt(i), i);
            }
            else
            {
                record.put(s.charAt(i), i);
                length++;
            }
        }
        if(length > maxLength){
            maxLength = length;
        }
        return maxLength;
    }
}
