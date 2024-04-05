class Solution {
    public int maxProfit(int[] prices) {
        int bestBuyPrice = Integer.MAX_VALUE;
        int curProfit = 0;
        int bestProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < bestBuyPrice) {
                bestBuyPrice = prices[i];
            } else {
                curProfit = prices[i] - bestBuyPrice;
                if (curProfit > bestProfit) {
                    bestProfit = curProfit;
                }
            }
        }

        return bestProfit;
    }
}