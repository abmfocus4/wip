class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1; // taking no coins to get amount 0 is 1 way

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; // making amount 0 is 1 way, don't take coin 
            for (int j = 1; j <= amount; j++) {
                // take
                int take = 0;
                if (j - coins[i - 1] >= 0) {
                    take = dp[i][j - coins[i-1]]; // can still use ith coins (unbounded knapsack)
                }

                // skip
                int skip = dp[i-1][j]; // don't take ith coin so result is same as i-1 change, and amount doesn't change because you didn't use ith coin
                dp[i][j] += take+skip;
            }
        }

        return dp[n][amount];
    }
}