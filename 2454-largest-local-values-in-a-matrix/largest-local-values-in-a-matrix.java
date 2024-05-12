class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int res_n = n - 2;
        int[][] res = new int[res_n][res_n];

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) { // fill in all entries of res_n
                res[i][j] = getLargestLocal(i, j, grid);
            }
        }
        return res;
    }

    private int getLargestLocal(int i, int j, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int row = i; row <= i+2; row++) {
            for (int col = j; col <= j+2; col++) { // 3x3 matrix max
                max = Math.max(max, grid[row][col]);
            }
        }

        return max;
    }
}