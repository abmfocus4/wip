// Better approach
// TC: O(m + n), SC: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;

        int i = 0, j = 0, k = 0;
        int idx1 = size/2;
        int elem1 = 0;

        int idx2 = size/2 - 1;
        int elem2 = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == idx1) {
                    elem1 = nums1[i];
                }
                if (k == idx2) {
                    elem2 = nums1[i];
                }
                i++;
                k++;
            } else {
                if (k == idx1) {
                    elem1 = nums2[j];
                }
                if (k == idx2) {
                    elem2 = nums2[j];
                }
                j++;
                k++;
            }
        }

        while (i < m) {
            if (k == idx1) {
                elem1 = nums1[i];
            }
            if (k == idx2) {
                elem2 = nums1[i];
            }
            i++;
            k++;
        }

        while (j < n) {
            if (k == idx1) {
                elem1 = nums2[j];
            }
            if (k == idx2) {
                elem2 = nums2[j];
            }
            j++;
            k++;
        }

        if (size % 2 == 0) { // even
            return (elem2 + elem1)/2.0;
        } else { // odd
            return elem1;
        }
    }
}