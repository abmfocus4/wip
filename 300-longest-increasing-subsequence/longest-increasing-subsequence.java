class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        // for every index find the lis
        int n = nums.length;
        if (nums.length <= 1) return nums.length;
        this.dp = new int[n][n+1];
        for (int[] row : dp) {
        Arrays.fill(row, -1);

        }
        return lis(nums, 0, -1);
    }

    private int lis(int[] nums, int currentIdx, int prevIdx) {
        if (currentIdx == nums.length) return 0;
        if (dp[currentIdx][prevIdx+1] != -1) return dp[currentIdx][prevIdx+1];
        int skip = lis(nums, currentIdx+1, prevIdx);
        int select = -1;
        if (prevIdx == -1 || nums[currentIdx] > nums[prevIdx]) {
            select = 1 + lis(nums, currentIdx + 1, currentIdx);
        }

        return dp[currentIdx][prevIdx+1] = Math.max(skip, select);
    }

}