// https://leetcode.com/problems/cherry-pickup/solutions/329945/very-easy-to-follow-step-by-step-recursive-backtracking-with-memoization-n-4


// Cannot take greedy: find max path from 0,0 to N,N & N,N to 0,0. local max is not equal to global max
// grid = [[1,1,1,0,1],
//         [0,0,0,0,0],
//         [0,0,0,0,0],
//         [0,0,0,0,0],
//         [1,0,1,1,1]].

// once we collect the cherry, 1->0, can be double counted by the other path

// to avoid this - start two routes from 0,0 at the same time and select global maxima collectively
// to avoid double counting, if both robots are at same cell, only count it once

// memo N^4
class Solution {
    private final int[][] dirs = {{1,0,1,0}, {0,1,0,1}, {1,0,0,1}, {0,1,1,0}};
    Integer[][][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        this.dp = new Integer[n][n][n][n]; // dp
        return Math.max(cherryPickup(0,0,0,0,grid), 0);
    }

    private int cherryPickup(int r1, int c1, int r2, int c2, int[][] grid) {
        int n = grid.length;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE; // no cherries can be found
        }

        if (dp[r1][c1][r2][c2] != null) { // dp
            return dp[r1][c1][r2][c2]; // everywhere ret do: dp[r1][c1][r2][c2] = xxx
        }

        if (r1 == n-1 && c1 == n-1) { // robot 1 reached end
            return dp[r1][c1][r2][c2] = grid[r1][c1];
        }

        if (r2 == n-1 && c2 == n-1) { // robot 2 reached end
            return dp[r1][c1][r2][c2] = grid[r2][c2];
        }

        int cherries = 0; // count cherries
        if (r1 == r2 && c1 == c2) { // are at the same cell
            cherries += grid[r1][c1];
        } else { // are at diff cells
            cherries += grid[r1][c1] + grid[r2][c2];
        }

    // since each person of the 2 person can move only to the bottom or to the right, then the total number of cherries
    // equals the max of the following possibilities:
    //    P1     |      P2
    //   DOWN    |     DOWN
    //   DOWN    |     RIGHT
    //   RIGHT   |     DOWN
    //   RIGHT   |     RIGHT
        int max = Integer.MIN_VALUE;
        for (int[] dir : dirs) {
            max = Math.max(max, cherryPickup(r1 + dir[0], c1 + dir[1], r2 + dir[2], c2 + dir[3], grid));
        }
        cherries += max;
        return dp[r1][c1][r2][c2] = cherries;
    }

}