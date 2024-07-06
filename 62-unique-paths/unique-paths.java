class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        this.dp = new Integer[m][n];
        return uniquePaths(0, 0, m, n);
    }

    private int uniquePaths(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int bottom = uniquePaths(i + 1, j, m, n);
        int right = uniquePaths(i, j + 1, m, n);

        return dp[i][j] = bottom + right;
    }


}