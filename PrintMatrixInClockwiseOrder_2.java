package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ruchit on 05-01-2018.
 * Print matrix in clockwise order
 * Eg: 3;3;1 2 3 4 5 6 7 8 9 - Ans= 1 2 3 6 9 8 7 4 5
 * Eg: 3;4;0 1 2 3 4 5 6 7 8 9 10 11 - Ans= 0 1 2 3 7 11 10 9 8 4 5 6
 */
public class PrintMatrixInClockwiseOrder_2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int rows, columns;
        String matrix[];
        while ((line = in.readLine()) != null) {
            String elements[] = line.split(";");
            rows = Integer.parseInt(elements[0]);
            columns = Integer.parseInt(elements[1]);
            matrix = elements[2].split(" ");
            int i = -1, k, startCol = 0, endCol = columns, startRow = 0, endRow = rows;
            while (startCol < endCol && startRow < endRow) {
                for (k = startCol; k < endCol; k++) {
                    i = i + 1;
                    System.out.print(matrix[i] + " ");
                }
                startRow++;
                for (k = startRow; k < endRow; k++) {
                    i = i + columns;
                    System.out.print(matrix[i] + " ");
                }
                endCol--;
                if (startRow < endRow) {
                    for (k = endCol - 1; k >= startCol; k--) {
                        i = i - 1;
                        System.out.print(matrix[i] + " ");
                    }
                    endRow--;
                }
                if (startCol < endCol) {
                    for (k = endRow - 1; k >= startRow; k--) {
                        i = i - columns;
                        System.out.print(matrix[i] + " ");
                    }
                    startCol++;
                }
            }
        }
    }
}
