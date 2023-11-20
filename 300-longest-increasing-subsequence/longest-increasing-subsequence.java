// Expl : https://www.youtube.com/watch?v=iyd-8fpqEgU
// ^ dp + recursion + memoization

class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int max = 1;

        // Space: O(N)
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // max lis at that point is 1

        // Time: O(N^2)
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) // increasing lis condition
                    dp[i] = Math.max(dp[j]+1, dp[i]); // add or skip part
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}