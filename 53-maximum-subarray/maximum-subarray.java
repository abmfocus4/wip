class Solution {
    // Time: O(n)
    // Kadane's Algo - works only cause of continuous subarray lookup
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int current_sum = max_sum;
        for (int i = 1; i < nums.length; i ++) {
            // decide whether to use sum upto that point or start fresh
            current_sum = Math.max(nums[i] + current_sum, nums[i]);
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }
}