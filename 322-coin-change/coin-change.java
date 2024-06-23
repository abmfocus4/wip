// Code: https://www.youtube.com/watch?v=GfyQ6zzalxk
// dp min/max path to target

// Explanation: https://www.youtube.com/watch?v=H9bfqozjoqs

// why not greedy? - https://leetcode.com/problems/coin-change/description/comments/2008918
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, amount + 1);
        cache[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    cache[i] = Math.min(cache[i], cache[i-coin] + 1);
                } else {
                    break;
                }
            }
        }
        return cache[amount] == amount + 1 ? -1 : cache[amount];
    }
}