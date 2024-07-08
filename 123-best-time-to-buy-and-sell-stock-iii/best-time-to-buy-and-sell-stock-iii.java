class Solution {
    public static final int BUY = 0;
    public static final int SELL = 1;
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    private int maxProfit(int[] prices, int numTransactions) {
        int n = prices.length;
        int[][] cur = new int[2][numTransactions + 1];
        int[][] prev = new int[2][numTransactions + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= numTransactions; k++) {
                // if you are allowed to buy now

                // if you buy, then you can't buy without selling
                // if you didn't buy, then profit you can still buy
                cur[BUY][k] = Math.max(-prices[i] + prev[SELL][k], 0 + prev[BUY][k]);
                
                // buy and sell together is one transaction
                // if you sell, then you reduce the number of transactions you can make
                // if you sell, then you can only buy
                // if you don't, then you can sell in the future and transaction update then
                cur[SELL][k] = Math.max(prices[i] + prev[BUY][k-1], 0 + prev[SELL][k]);

                prev = cur; 
            }
        }

        // in beginning you can buy and still can make all numTransactions transactions
        return cur[BUY][numTransactions];
    }
}