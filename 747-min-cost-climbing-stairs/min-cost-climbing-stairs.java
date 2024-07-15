class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev_prev = cost[0];
        int prev = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(prev_prev, prev) + cost[i];
            prev_prev = prev;
            prev = current;
        }

        return Math.min(prev_prev, prev);
    }
}