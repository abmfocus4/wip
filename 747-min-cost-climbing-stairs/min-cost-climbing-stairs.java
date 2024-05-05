// greedy: not related to dp
// if we can modify cost
class Solution {
    // if we can modify the staircase cost arr
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}