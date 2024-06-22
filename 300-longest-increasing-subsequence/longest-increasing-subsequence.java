class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1d arr = store maxlis with that index as last added element
        int n = nums.length;
        if (n <= 1)
            return n;

        int maxLis = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLis = Math.max(maxLis, dp[i]);
            }
        }

        return maxLis;
    }
}