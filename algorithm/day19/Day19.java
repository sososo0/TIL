package algorithm.day19;

import java.io.*;
import java.util.StringTokenizer;

public class Day19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;
        int[][] grid = new int[rows][cols];

        int maxValue = 0;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int value = calculateValue(r, c);
                grid[r - r1][c - c1] = value;
                maxValue = Math.max(maxValue, value);
            }
        }

        int maxLen = String.valueOf(maxValue).length();
        for (int r = 0; r < rows; r++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                rowOutput.append(String.format("%" + maxLen + "d ", grid[r][c]));
            }
            System.out.println(rowOutput);
        }
    }

    private static int calculateValue(int row, int col) {
        int level = Math.max(Math.abs(row), Math.abs(col));
        int start = (2 * level - 1) * (2 * level - 1) + 1;

        if (row == level) { 
            return start + 7 * level - 1 + col;
        }
        if (col == -level) {
            return start + 5 * level - 1 + row;
        }
        if (row == -level) {
            return start + 3 * level - 1 - col;
        }
        return start + level - 1 - row;
    }
}
