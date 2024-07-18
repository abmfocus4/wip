class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] largestLocal = new int[n-2][n-2];
        int resN = n-2;
        for (int i = 0; i < resN; i++) {
            for (int j = 0; j < resN; j++) {
                largestLocal[i][j] = getLargestLocal(i, j, grid);
            }
        }

        return largestLocal;
    }

    private int getLargestLocal(int i, int j, int[][] grid) {
        int max = 0;
        for (int row = i; row <= i + 2; row++) {
            for (int col = j; col <= j + 2; col++) {
                max = Math.max(max, grid[row][col]);
            }
        }

        return max;
    }
}