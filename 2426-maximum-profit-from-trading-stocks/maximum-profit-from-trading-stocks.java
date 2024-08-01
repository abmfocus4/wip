class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        Integer[][] memo = new Integer[present.length][budget+1];
        return solve(present, future, 0, budget, memo);
    }
    
    int solve(int[] present, int[] future, int i, int budget, Integer[][] memo) {
        if(budget < 0 || i >= present.length) {
            return 0;
        }

        if(memo[i][budget] != null) {
            return memo[i][budget];
        }

        int trade = 0, skipTrade = 0;
        if(present[i] < future[i] && present[i] <= budget) { // if we can make a profit and we have the budget
            int profit = future[i] - present[i];
            int remainingBudget = budget - present[i];
            trade = profit + solve(present, future, i + 1, remainingBudget, memo);
        }

        skipTrade = solve(present, future, i + 1, budget, memo);
        
        return memo[i][budget] = Math.max(trade, skipTrade);
    }
}