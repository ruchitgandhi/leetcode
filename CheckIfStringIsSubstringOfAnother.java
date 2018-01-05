package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * Created by Ruchit.
 * <p>
 * Check if given string is substring of another. The string can have * which means zero or more characters are allowed
 * in place of the *. To escape the star \ might be used if the string actually contains a star as one of its characters.
 * Allowed characters in string are alphabets, * and \.
 * <p>
 * Eg: hirevue,h*vue - true; old,young - false
 */
public class CheckIfStringIsSubstringOfAnother {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String a, b, line;
        while ((line = in.readLine()) != null) {
            String inputs[] = line.split(",");
            a = inputs[0];
            b = inputs[1];
            System.out.println(checkIfSubstring(a, b));
        }
    }

    public static boolean checkIfSubstring(String a, String b) {
        boolean substring = true;
        int k;
        for (k = 0; k < a.length(); k++) {
            if (a.charAt(k) == b.charAt(0)) {
                if (check(a.substring(k, a.length()), b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(String a, String b) {
        boolean substring = true;
        int i, j;
        for (i = 0, j = 0; i < a.length() && j < b.length() && substring; i++, j++) {
            if (b.charAt(j) == '\\') {
                j++;
            } else if (b.charAt(j) == '*') {
                if (checkIfSubstring(a.substring(i, a.length()), b.substring(j + 1, b.length()))) {
                    break;
                }
            } else if (a.charAt(i) != b.charAt(j)) {
                substring = false;
            }
        }
        if (j < b.length()) {
            substring = false;
        }
        return substring;
    }
}
