// https://leetcode.com/problems/minimum-operations-to-make-numbers-non-positive/solutions/3614589/c-java-binary-search-math-w-detailed-explanation
// best explanation ^^
class Solution {
    // imp: x > y
    public int minOperations(int[] nums, int x, int y) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int left = 1;
        int right = (max + y - 1) / y; // min y subtractions to make all elems neg
        x -= y; // all need to be subtracted by y, one needs to be subtracted by x too

        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2; // mid = num ops to make all neg
            if (check(nums, x, y, mid)) { // if true, store res and try for smaller num
                res = mid;
                right = mid - 1;
            } else { // if false, try larger number
                left = mid + 1;
            }
        }
        return right + 1;
    }

    // The check method checks whether the total number of operations maxOps is
    // sufficient to bring all numbers in the array to zero or less.
    public boolean check(int[] nums, int x, int y, int maxOps) {
        int remainingOps = maxOps;
        for (int num : nums) {
            int numOps = (num + y - 1) / y;
            if (numOps > maxOps) { // if more y ops needed to decrease num that what we can perform
                // decrease num by x to fulfil the remaining
                remainingOps -= (num - maxOps * y + x - 1) / x; // num x operations
                if (remainingOps < 0)
                    return false;
            }
        }
        return true;
    }
}