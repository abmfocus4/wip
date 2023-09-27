class Solution {
    // bottom up dp approach
    public int climbStairs(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // nth step is needed, array need to be n+1
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1; // store base value
        
        for (int i = 2; i <= n; i++) { // step calculation after base case
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}