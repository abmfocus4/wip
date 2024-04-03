class Solution {
    public int uniquePaths(int m, int n) {
        // for each cell from bottom to top
        // find the number of uniquePaths to reach the target cell
        // reuse the precomputed unique paths of children cells when computing the value for destination cells

        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        for (int i = m -2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int bottom = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = bottom + right;
            }
        }

        return dp[0][0];
    }
}