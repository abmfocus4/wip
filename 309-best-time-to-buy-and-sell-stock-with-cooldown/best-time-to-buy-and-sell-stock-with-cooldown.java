class Solution {
    public static final int BUY = 0;
    public static final int SELL = 1;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2];
        dp[n][BUY] = dp[n][SELL] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][BUY] = Math.max(-prices[i] + dp[i + 1][SELL], 0 + dp[i + 1][BUY]);
            dp[i][SELL] = Math.max(prices[i] + dp[i + 2][BUY], 0 + dp[i + 1][SELL]);
        }
        return dp[0][BUY];
    }

}