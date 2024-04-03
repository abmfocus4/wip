class Solution {
    // top down approach
    // parent stair = child stair tells from many ways to climb to top
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsFrom(n, dp, 0);
    }

    public int climbStairsFrom(int n, int[] dp, int stair) {
        if (stair > n) return 0;
        if (dp[stair] != -1) return dp[stair];
        if (stair == n) return 1;

        int oneStep = climbStairsFrom(n, dp, stair + 1);
        int twoStep = climbStairsFrom(n, dp, stair + 2);

        dp[stair] = oneStep + twoStep;
        return dp[stair]; 
    }
}