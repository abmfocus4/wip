// https://www.youtube.com/watch?v=6aML2-rJJik&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=14&ab_channel=codestorywithMIK
// - recursion & memoization
// TC: O(m*n) = SC
class Solution {
    int m, n;
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        dp = new Integer[m][n];

        return solve(grid, 0, 0);
    }

    private int solve(int[][] grid, int i, int j) {

        // destination
        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = grid[i][j];
        } 

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // base cases
        // last col
        if (j == n-1) {
            return dp[i][j] = grid[i][j] + solve(grid, i+1, j);
        }

        // last row
        if (i == m-1) {
            return dp[i][j] = grid[i][j] + solve(grid, i , j+1);
        }

        return dp[i][j] = grid[i][j] + Math.min(solve(grid, i+1, j), solve(grid, i , j+1));

    }
}