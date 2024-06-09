// Brute force approach
// TC: O(m + n) == SC
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int[] nums = new int[total];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums[k++] = nums1[i++];
        }

        while (j < n) {
            nums[k++] = nums2[j++];
        }

        if (total % 2 == 0) { // even
            return (nums[total/2] + nums[total/2 - 1])/2.0;
        } else { // odd
            return nums[total/2];
        }
    }
}