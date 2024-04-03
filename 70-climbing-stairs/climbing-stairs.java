class Solution {
    // bottom up approach
    // already at step n - 1, how to compute step 0 onwards distinct ways
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        for (int i = n-2; i >= 0; i--) {
            int oneStep = dp[i+1];
            int twoStep = dp[i+2];
            dp[i] = oneStep + twoStep;
        }
        return dp[0];
    }
}