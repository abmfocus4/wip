class Solution {
    Integer[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.dp = new Integer[amount + 1];
        return coinChange(amount);
    }

    private int coinChange(int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount] != null) {
            return dp[amount];
        }
        int coinChange = Integer.MAX_VALUE;
        for (int coin : coins) {
            int complCoinChange = coinChange(amount - coin);
            if (complCoinChange != -1) {
                coinChange = Math.min(coinChange, complCoinChange);
            }
        }

        if (coinChange == Integer.MAX_VALUE) {
            coinChange = -1;
        } else {
            coinChange += 1;
        }

        return dp[amount] = coinChange;
    }
}