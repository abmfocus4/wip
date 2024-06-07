// https://leetcode.com/problems/single-number-ii/solutions/3714928/bit-manipulation-c-java-python-beginner-friendly
class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            seenOnce = (seenOnce ^ num) & (~seenTwice);
            seenTwice = (seenTwice ^ num) & (~seenOnce);
        }
        return seenOnce;
    }
}