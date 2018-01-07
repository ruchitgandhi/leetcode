package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ruchit.
 */
public class FindAnagramMappings {
    public static void main(String[] args) {
        /*int A[] = {12, 28, 46, 32, 50};
        int B[] = {50, 12, 32, 46, 28};*/
        int A[] = {12, 28, 50, 32, 50};
        int B[] = {50, 12, 32, 50, 28};
        int result[] = anagramMappings(A, B);

        for (int i : result) {
            System.out.print(i);
        }
    }

    private static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Stack> recordOfB = new HashMap<>();
        int result[] = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            if (recordOfB.containsKey(B[i])) {
                recordOfB.get(B[i]).push(i);
            } else {
                Stack<Integer> st = new Stack();
                st.push(i);
                recordOfB.put(B[i], st);
            }
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = ((int) recordOfB.get(A[i]).pop());
        }

        return result;
    }
}
