// understand qs : https://leetcode.com/problems/minimize-maximum-of-array/description/comments/1854113
// https://www.youtube.com/watch?v=AeHMvcKuR0Y&ab_channel=NeetCodeIO
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long res = nums[0];
        long total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            res = Math.max(res, (total+i)/(i+1)); // trick to calculate ceiling
        }

        return (int)res;
    }
}