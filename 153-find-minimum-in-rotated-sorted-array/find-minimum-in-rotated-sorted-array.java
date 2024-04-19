class Solution {
    public int findMin(int[] nums) {
        // similar to this : 33. Search in Rotated Sorted Array - https://leetcode.com/problems/search-in-rotated-sorted-array
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midpoint = left + (right - left)/2;
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        return nums[left];
    }
}