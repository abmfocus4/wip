// https://www.youtube.com/watch?v=JC1fSPdJjMc&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=15&ab_channel=codestorywithMIK
class Solution {
    // TC: O(m*n) = SC
    int m, n;
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.dp = new Integer[m][n];
        return solve(obstacleGrid, 0, 0);
    }

    private int solve(int[][] obstacleGrid, int i, int j) {
        // don't need to check i < 0 and j < 0
        if (i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] == 1) { // set grid[i][j] != -1
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // if we can go all 4 directions, risk of visiting repeated cell
        // int temp = grid[i][j];
        // grid[i][j] == -1;
        int right = solve(obstacleGrid, i+1, j);
        int down =  solve(obstacleGrid, i, j+1);
        // grid[i][j] = temp;
        return dp[i][j] = right + down;
    }
}