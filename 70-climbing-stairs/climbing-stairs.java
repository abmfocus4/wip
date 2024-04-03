class Solution {
    public int climbStairs(int n) {
        // to climb n stairs top
        // sum of n-1 and n-2 routes
        HashMap<Integer, Integer> dp = new HashMap();
        return climbStairsTo(dp, n);
    }

    public int climbStairsTo(HashMap<Integer, Integer> dp, int stairs) {
        if (stairs == 0 || stairs == 1) return 1;
        if (!dp.containsKey(stairs)) dp.put(stairs, climbStairsTo(dp, stairs-1) + climbStairsTo(dp, stairs-2));
        return dp.get(stairs);
    }
}