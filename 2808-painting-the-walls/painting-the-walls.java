// sum : time taken by paid >= sum remaining
// https://www.youtube.com/watch?v=qMZJunF5UaI&ab_channel=NeetCodeIO
// https://www.youtube.com/watch?v=FkJ2_hr6DRo&ab_channel=codestorywithMIK
class Solution {
    int[][] memo;
    int n;

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }

    public int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) {
            return 0;
        }

        if (i >= n) {
            return (int) 1e9;
        }

        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }

        // Let's say that we have the paid painter paint the ith
        // wall. It costs us cost[i] money. The paid painter will paint 1 wall and be
        // occupied for time[i] time. While the paid painter is occupied, the free
        // painter can paint time[i] walls (since the free painter paints one wall per
        // unit of time). Overall, we spent cost[i] money to paint 1 + time[i] walls.
        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }
}