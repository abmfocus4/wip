class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int step1 = cost[0];
        int step2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(step1, step2) + cost[i];
            step1 = step2;
            step2 = current;
        }

        return Math.min(step1, step2);
    }
}