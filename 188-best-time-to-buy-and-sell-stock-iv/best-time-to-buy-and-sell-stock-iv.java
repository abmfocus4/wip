// class Solution {
//     public int maxProfit(int k, int[] prices) {
        
//     }
// }

// videos - https://www.youtube.com/watch?v=-uQGzhYj8BQ&list=TLPQMDgwNjIwMjTSiTgJSC2Yog&index=7&ab_channel=takeUforward
// brute force onwards code - https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36
class Solution {
    public int maxProfit(int k, int[] prices) {
        // int k = 2;
        // Create pricesays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        int[][] ahead = new int[2][k+1];
        int[][] cur = new int[2][k+1];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        for (int[] row : ahead) {
            Arrays.fill(row, 0);
        }

        int profit = 0;
        int n = prices.length;
        // Iterate through the pricesay in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0][cap], -prices[ind] + ahead[1][cap]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1][cap], prices[ind] + ahead[0][cap-1]);
                }
                cur[buy][cap] = profit;
            }

            // Update the 'ahead' pricesay with the current profit values
            ahead = cur;
        }
        }
        return cur[0][k]; // The maximum profit is stored in 'cur[0]'
    }
}