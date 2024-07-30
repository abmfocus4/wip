class Solution {
    Integer[][][] memo;
    public int maximumLength(int[] nums, int k) {
        // max "good subsequence"
        // prev idx, cur idx needed to maintain subsequence
        // take or not take curIdx
        // k - 1 when nums[i] != nums[i+1]
        int n = nums.length;
        this.memo = new Integer[n][n+1][k+1];
        return maximumLength(nums, 0, -1, k);
    }

    private int maximumLength(int[] nums, int curIdx, int prevIdx, int k) {
        if (curIdx == nums.length) {
            return 0;
        }

        if (memo[curIdx][prevIdx + 1][k] != null) {
            return memo[curIdx][prevIdx + 1][k];
        }

        int take = 0;
        if (prevIdx == -1 || nums[curIdx] == nums[prevIdx]) {
            take = 1 + maximumLength(nums, curIdx + 1, curIdx, k);
        } else if (prevIdx == -1 || nums[curIdx] != nums[prevIdx] && k > 0){
            take = 1 + maximumLength(nums, curIdx + 1, curIdx, k - 1);
        }

        int notTake = maximumLength(nums, curIdx + 1, prevIdx, k);

        return memo[curIdx][prevIdx + 1][k] = Math.max(take, notTake);
    }
}