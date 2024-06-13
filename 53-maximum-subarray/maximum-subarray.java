class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left)/2;
        int leftHalfMax = Integer.MIN_VALUE, rightHalfMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int l = mid; l >= left; l--) {
            sum += nums[l];
            leftHalfMax = Math.max(leftHalfMax, sum);
        }

        sum = 0;
        for (int r = mid + 1; r <= right; r++) {
            sum += nums[r];
            rightHalfMax = Math.max(rightHalfMax, sum);
        }

        int leftMax = helper(nums, left, mid);
        int rightMax = helper(nums, mid + 1, right);
        int middleMax = leftHalfMax + rightHalfMax;

        return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}