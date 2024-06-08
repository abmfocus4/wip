// https://www.youtube.com/watch?v=6aML2-rJJik&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=14&ab_channel=codestorywithMIK
// bottom up : tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        // dp[i][j] : minPathSum to reach i,j from 0,0

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];

        // base cases
        dp[0][0] = grid[0][0];

        // fill 1st row, // came from left
        for (int col = 1; col < n; col++) {
            dp[0][col] = grid[0][col] + dp[0][col-1];
        }

        // fill 1st col, came from top
        for (int row = 1; row < m; row++) {
            dp[row][0] = grid[row][0] + dp[row-1][0];
        }

        // fill rest of rows and cols
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = grid[row][col] + Math.min(dp[row-1][col], dp[row][col-1]);
            }
        }

        return dp[m-1][n-1];
    }
}