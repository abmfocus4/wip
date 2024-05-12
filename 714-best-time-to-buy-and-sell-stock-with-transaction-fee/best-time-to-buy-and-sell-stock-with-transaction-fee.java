// https://www.youtube.com/watch?v=nGJmxkUJQGs&ab_channel=takeUforward
// https://www.youtube.com/watch?v=k4eK-vEmnKg&ab_channel=takeUforward
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // Create pricesays 'prev' and 'cur' to store the maximum profit prev and current profit
        int[] prev = new int[2];
        int[] cur = new int[2];

        // Base condition: If we have no stocks to trans or sell, profit is 0
        prev[0] = prev[1] = 0;

        int profit = 0;
        int n = prices.length;
        // Iterate through the pricesay in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int trans = 0; trans <= 1; trans++) { // 0: sell and 1: trans
                if (trans == 0) { // We can trans the stock
                    profit = Math.max(0 + prev[0], -prices[ind] + prev[1] - fee); // remove fee
                }

                if (trans == 1) { // We can sell the stock
                    profit = Math.max(0 + prev[1], prices[ind] + prev[0]);
                }
                cur[trans] = profit;
            }

            // Update the 'prev' pricesay with the current profit values
            prev = cur;
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }
}