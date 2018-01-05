package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ruchit.
 * <p>
 * Print Mth element from end in the given sequence
 * Eg : a b c d 4 - Ans a
 */
public class PrintMthElementFromEnd {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int positionNeeded;
        while ((line = in.readLine()) != null) {
            line = line.replaceAll(" ", "");
            int lineLength = line.length();
            if ((lineLength > 1) && line.charAt(lineLength - 2) == '-') {
                System.out.println("");
            } else {
                int numberInLine = Integer.parseInt(line.substring(line.length() - 1));
                if (numberInLine > 0) {
                    positionNeeded = line.length() - numberInLine - 1;
                    if (positionNeeded < 0) {
                        System.out.println("");
                    } else {
                        System.out.println(line.charAt(positionNeeded));
                    }
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
