package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ruchit.
 * <p>
 * Print matrix in clockwise order
 * Eg: 3;3;1 2 3 4 5 6 7 8 9 - Ans= 1 2 3 6 9 8 7 4 5
 */
public class PrintMatrixInClockWiseOrder {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int rows, columns;
        String matrix;
        while ((line = in.readLine()) != null) {
            String elements[] = line.split(";");
            rows = Integer.parseInt(elements[0]);
            columns = Integer.parseInt(elements[1]);
            matrix = elements[2].replaceAll(" ", "");
            int counter = 0;
            String array[][] = new String[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = "" + matrix.charAt(counter++);
                }
            }
            int i, startRow = 0, startCol = 0, endRow = rows, endCol = columns;

            while (startRow < endRow && startCol < endCol) {
                for (i = startCol; i < endCol; i++) {
                    System.out.print(array[startRow][i] + " ");
                }
                startRow++;

                for (i = startRow; i < endRow; i++) {
                    System.out.print(array[i][endCol - 1] + " ");
                }
                endCol--;

                if (startRow < endRow) {
                    for (i = endCol - 1; i >= startCol; i--) {
                        System.out.print(array[endRow - 1][i] + " ");
                    }
                    endRow--;
                }

                if (startCol < endCol) {
                    for (i = endRow - 1; i >= startRow; i--) {
                        System.out.print(array[i][startCol] + " ");
                    }
                    startCol++;
                }
            }
            System.out.println("");
        }
    }
}
