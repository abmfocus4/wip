// knapsack probs: https://www.youtube.com/watch?v=mBNrRy2_hVs&ab_channel=NeetCode
// ref: https://www.youtube.com/watch?v=Mjy4hd2xgrs&ab_channel=NeetCode

// best ref: https://leetcode.com/problems/coin-change-ii/solutions/99212/knapsack-problem-java-solution-with-thinking-process-o-nm-time-and-o-m-space
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += ((j - coins[i-1] >= 0) ? dp[i][j - coins[i-1]] : 0) + dp[i-1][j];
            }
        }
        return dp[coins.length][amount];

    }
}