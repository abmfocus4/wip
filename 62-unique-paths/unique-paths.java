class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return uniquePathsFrom(0, 0, cache, m, n);
    }

    public int uniquePathsFrom(int row, int col, int[][] cache, int m, int n) {
        if (row > m - 1 || col > n - 1) return 0;
        if (row == m-1 && col == n-1) return 1;
        if (cache[row][col] != -1) return cache[row][col];
        int bottom = uniquePathsFrom(row+1, col, cache, m, n);
        int right = uniquePathsFrom(row, col+1, cache, m, n);
        cache[row][col] = bottom+right;
        return cache[row][col];
    }
}