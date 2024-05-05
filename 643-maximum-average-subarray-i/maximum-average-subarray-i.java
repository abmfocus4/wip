// https://leetcode.com/problems/maximum-average-subarray-i/solutions/3799916/java-100-faster-solution-sliding-window
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        // init first window
       for(int i = 0; i < k; i ++) 
           sum += nums[i];

       double maxSum = sum;

       for(int i = k; i < nums.length; i ++) {
        // add current element, remove first element in window
           sum += nums[i] - nums[i - k];
           maxSum = Math.max(maxSum, sum);
       }

       return maxSum/k;
    }
}