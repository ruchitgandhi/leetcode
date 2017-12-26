package com.practice.leetcode;

import java.util.Scanner;

/**
 * Created by Ruchit.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(convert(s.nextLine(), s.nextInt()));
    }

    public static String convert(String s, int numRows) {
        int i=0,l=0;
        StringBuffer[] buffer = new StringBuffer[numRows];
        for(i=0; i<numRows; i++){
            buffer[i] = new StringBuffer();
        }
        while(l < s.length()) {
            for (i = 0; i < numRows && l < s.length(); i++) {
                buffer[i].append(s.charAt(l++));
            }
            for (i = numRows - 2; i > 0 && l < s.length(); i--) {
                buffer[i].append(s.charAt(l++));
            }
        }
        String sb = "";
        for(i=0; i<buffer.length; i++){
            sb+=buffer[i];
        }
        return sb;
    }

    /*public static String convert(String s, int numRows) {
        int first, second, length;
        length = numRows % 2 != 0 ? (numRows + 1)/2 : numRows/2;

        for(int i=0; i<length; i++){
            System.out.print(s.charAt(i));
            first = 2*numRows - 2*(i+1);
            System.out.print(s.charAt(i + first));
            if(i!=0 && i!=numRows-1) {
                second = 2*numRows - 2*(numRows-i-1);
                System.out.print(s.charAt(i + second));
            }
        }

        return null;
    }*/
}
