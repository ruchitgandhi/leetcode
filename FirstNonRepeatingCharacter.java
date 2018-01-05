package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruchit.
 * <p>
 * Print first non repeating character in string
 * Eg: yellow - Ans = y
 */
public class FirstNonRepeatingCharacter {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Map<Character, Integer> record = new HashMap<>();
        char c;
        boolean found;
        while ((line = in.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                c = line.charAt(i);
                if (record.containsKey(c)) {
                    record.put(c, record.get(c) + 1);
                } else {
                    record.put(c, 1);
                }
            }

            found = false;
            for (int i = 0; i < line.length() && !found; i++) {
                if (record.get(line.charAt(i)) == 1) {
                    System.out.println(line.charAt(i));
                    found = true;
                }
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }
}
