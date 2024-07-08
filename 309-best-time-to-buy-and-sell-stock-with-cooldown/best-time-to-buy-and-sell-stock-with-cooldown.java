class Solution {
    public static final int BUY = 0;
    public static final int SELL = 1;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // Initialize arrays to store DP states
        int[] prev = new int[2];   // dp[i + 1][BUY], dp[i + 1][SELL]
        int[] prev_prev = new int[2];  // dp[i + 2][BUY], dp[i + 2][SELL]
        int[] cur = new int[2];     // dp[i][BUY], dp[i][SELL]
        
        // Initial values (base case)
        prev[BUY] = prev[SELL] = 0;
        prev_prev[BUY] = prev_prev[SELL] = 0;
        
        // Iterate from the end of the prices array to the beginning
        for (int i = n - 1; i >= 0; i--) {
            cur[BUY] = Math.max(-prices[i] + prev[SELL], prev[BUY]);
            cur[SELL] = Math.max(prices[i] + prev_prev[BUY], prev[SELL]);
            
            // Update prev and prev_prev arrays for the next iteration
            prev_prev[BUY] = prev[BUY];
            prev_prev[SELL] = prev[SELL];
            prev[BUY] = cur[BUY];
            prev[SELL] = cur[SELL];
        }
        
        // The result is stored in cur[BUY] after processing all days
        return cur[BUY];
    }
}
