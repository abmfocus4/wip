class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // get max sum 
        int maxSum = kadaneMax(nums);
        // get max circular sum
        int totalSum = Arrays.stream(nums).sum();
        int minSum = kadaneMin(nums);
        int cirSum = totalSum - minSum;
        // return max of both with check for edge case of all neg numbers
        if (cirSum > 0) {
            return Math.max(cirSum, maxSum);
        } else {
            return maxSum;
        }
    }

    private int kadaneMax(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

        private int kadaneMin(int[] nums) {
        int curSum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.min(curSum + nums[i], nums[i]);
            minSum = Math.min(minSum, curSum);
        }

        return minSum;
    }


}