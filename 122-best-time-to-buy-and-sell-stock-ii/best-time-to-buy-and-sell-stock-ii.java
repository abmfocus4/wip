class Solution {
    public static final int BUY = 0;
    public static final int SELL = 1;
    public int maxProfit(int[] prices) {
        // buy and sell transactions

        int n = prices.length;

        // calculate current profit based on
        // 1) can be buy or not buy
        // 2) hold or transaction
        int[] cur = new int[2];
        int[] prev = new int[2];

        prev[0] = prev[1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // allowed to buy
            // buy or hold
            cur[BUY] = Math.max(-prices[i] + prev[SELL], 0 + prev[BUY]);
            // allowed to sell
            // sell or hold
            cur[SELL] = Math.max(prices[i] + prev[BUY], 0 + prev[SELL]);
            prev = cur;
        }

        return cur[BUY];
    }
}