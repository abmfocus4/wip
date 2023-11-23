// Code: https://www.youtube.com/watch?v=GfyQ6zzalxk
// dp min/max path to target

// Explanation: https://www.youtube.com/watch?v=H9bfqozjoqs

// why not greedy? - https://leetcode.com/problems/coin-change/description/comments/2008918
class Solution {
    int[] coins;
    Integer[] cache;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new Integer[amount + 1]; // starting from 0 = 0,1,2,3,...,n = (n+1)
        return helper(amount); // returns min coins to get this amt
    }

    private int helper(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (cache[amount] != null) return cache[amount];

        int minCoinChange = Integer.MAX_VALUE;
        
        for (int num : coins) {
            int curMinCoinChange = helper(amount - num); // like dp[amt - num]
            if (curMinCoinChange != -1) {
                minCoinChange = Math.min(minCoinChange, curMinCoinChange);
            }
        }

        // minCoinChange rn is min of dp[amt - num] given some num in coins

        if (minCoinChange == Integer.MAX_VALUE) {
            minCoinChange = -1;
        } else {
            minCoinChange += 1; // only one coin is added to dp[amt - num] == total path
        }

        cache[amount] = minCoinChange;
        return cache[amount];
    }
}