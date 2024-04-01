class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}