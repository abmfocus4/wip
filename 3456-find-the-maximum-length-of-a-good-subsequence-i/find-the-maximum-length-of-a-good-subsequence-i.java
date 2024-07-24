class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int curIdx = 0;
        int prevIdx = -1;
        Integer[][][] memo = new Integer[n][n+1][k+1];
        return getMaximumLength(curIdx, prevIdx, k, nums, memo);
    }

    private int getMaximumLength(int curIdx, int prevIdx, int k, int[] nums, Integer[][][] memo) {
        if (curIdx == nums.length) {
            return 0;
        }

        if (memo[curIdx][prevIdx + 1][k] != null) {
            return memo[curIdx][prevIdx + 1][k];
        }

        // take curIdx
        int take = 0;
        // 1. nums[i] == nums[prevIdx]
        // 2. nums[i] != nums[prevIdx] 
        if (prevIdx == -1 || nums[curIdx] == nums[prevIdx]) {
            take = 1 + getMaximumLength(curIdx + 1, curIdx, k, nums, memo);
        } else if (prevIdx == -1 || nums[curIdx] != nums[prevIdx] && k > 0) {
            take = 1 + getMaximumLength(curIdx + 1, curIdx, k - 1, nums, memo);
        }

        // not take curIdx
        int notTake = getMaximumLength(curIdx + 1, prevIdx, k, nums, memo);

        return memo[curIdx][prevIdx + 1][k] = Math.max(take, notTake);
    }


}