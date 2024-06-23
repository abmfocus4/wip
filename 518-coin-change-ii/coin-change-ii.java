// final prep
// code story understand recursion tree - https://www.youtube.com/watch?v=HhSZQkdJZok&ab_channel=codestorywithMIK
// knapsack problem link understand - https://www.youtube.com/watch?v=mBNrRy2_hVs&ab_channel=NeetCode
// written solution - https://leetcode.com/problems/coin-change-ii/solutions/99212/knapsack-problem-java-solution-with-thinking-process-o-nm-time-and-o-m-space


// (not advised) code ref: https://www.youtube.com/watch?v=Mjy4hd2xgrs&ab_channel=NeetCode

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                // take
                int take = 0;
                if(j - coins[i - 1] >= 0) {
                    take = dp[i][j - coins[i-1]];
                }
                // skip
                int skip = dp[i-1][j];
                dp[i][j] += take + skip;
            }
        }
        return dp[coins.length][amount];

    }
}