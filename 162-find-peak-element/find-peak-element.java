class Solution {
    // https://leetcode.com/problems/find-peak-element/solutions/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
    public int findPeakElement(int[] nums) {
        // step in the direction of the ascend to reach the peak
        int N = nums.length;

        // if only one element in the list
        if (N == 1) {
            return 0;
        }

        // check both the boundaries
        if (nums[0] > nums[1]) return 0;
        if (nums[N - 1] > nums[N - 2]) return N-1;
        
        int left = 1; // adjust boundary after checking first and last num
        int right = N - 2;

        while (left <= right) {
            int mid = left + (right - left)/2;
            // search on the side of the array which is larger than the mid
            // then we can guarantee that there will be a peak element
            
            if (nums[mid - 1] > nums[mid]) { // search left space
                right = mid - 1;
            } else if (nums[mid + 1] > nums[mid]) { // search right space
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}