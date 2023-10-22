// WHEN YOU SEE SORTED ARRAY SEARCH PROBELEM - ALWAYS THINK BINARY SEARCH O(logn) time comp
class Solution {
    // you will find the min (pivot) where there is an inflection
    // in sorted array, curr value is greated than prev value
    // but at inflection point, curr value will be less than prev value
    // Ref: https://www.youtube.com/watch?v=IzHR_U8Ly6c
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;
        int midpoint = 0;

        while (left < right) {
            midpoint = left + (right - left)/2; // to prevent overflow midpoint = r/2 + l/2
            if (midpoint > 0 && nums[midpoint] < nums[midpoint-1]) return nums[midpoint]; // inflection in sorted array
            else if (nums[left] <= nums[midpoint] && nums[right] < nums[midpoint]) left = midpoint + 1;
            else right = midpoint - 1;
        }

        return nums[left];
    }
}