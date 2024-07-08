class Solution {
    public int maxProfit(int[] prices) {
        int bestBuyPrice = Integer.MAX_VALUE;
        int curProfit = 0;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < bestBuyPrice) {
                bestBuyPrice = price;
            } else {
                curProfit = price - bestBuyPrice;
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }
        }

        return maxProfit;
    }
}