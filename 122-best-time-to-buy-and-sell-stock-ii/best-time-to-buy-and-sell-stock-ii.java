// similar to https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int maxProfit(int[] prices) {
        // Create pricesays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        int profit = 0;
        int n = prices.length;
        // Iterate through the pricesay in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], prices[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' pricesay with the current profit values
            ahead = cur;
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }
}