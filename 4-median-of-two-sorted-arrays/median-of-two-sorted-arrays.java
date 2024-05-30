// simple approach - https://www.youtube.com/watch?v=6D9T2ZY8h5c&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=12&ab_channel=codestorywithMIK
// https://www.youtube.com/watch?v=7nABqJCEMuY&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=13&ab_channel=codestorywithMIK
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // consider nums1 to be smaller than nums2
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, r = n1; // n1 not n1 -1
        int n = n1 + n2;

        while (l <= r) {
            int Px = (l + r) >> 1;
            int Py = (n1 + n2 + 1) / 2 - Px; // left

            int l1 = Px == 0 ? Integer.MIN_VALUE : nums1[Px - 1]; // took no elems on the left from nums1
            int l2 = Py == 0 ? Integer.MIN_VALUE : nums2[Py - 1];
            int r1 = Px == n1 ? Integer.MAX_VALUE : nums1[Px]; // took all elems on the left, none on right
            int r2 = Py == n2 ? Integer.MAX_VALUE : nums2[Py];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) // total odd number elems in list
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if (l1 > r2) { // took too many elements on left, move one to right, move partition Px to left by 1
                r = Px - 1;
            } else {
                l = Px + 1;
            }

        }

        return 0;
    }
}