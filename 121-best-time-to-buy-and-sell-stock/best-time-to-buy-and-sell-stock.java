class Solution {
    public int maxProfit(int[] prices) {
        int bestPriceToBuy = prices[0];
        int currentProfit = 0;
        int bestProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (bestPriceToBuy > prices[i]) {
                bestPriceToBuy = prices[i];
            } else {
                currentProfit = prices[i] - bestPriceToBuy;
                if (currentProfit > bestProfit) {
                    bestProfit = currentProfit;
                }
            }
        }

        return bestProfit;
    }
}