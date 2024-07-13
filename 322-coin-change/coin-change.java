class Solution {
    int[] coins;
    int[] cache;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new int[amount + 1];
        Arrays.fill(cache, -2); // unfilled is 2
        return coinChange(amount);
    }

    private int coinChange(int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (cache[amount] != -2) {
            return cache[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int diffCoinChange = coinChange(amount - coin);
            if (diffCoinChange != -1) {
                minCoins = Math.min(diffCoinChange, minCoins);
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            cache[amount] = -1;
        } else {
            cache[amount] = minCoins + 1;
        }

        return cache[amount];
    }
}