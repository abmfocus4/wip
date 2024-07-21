class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;

        int[] count = new int[2];

        while (end < nums.length) {
            count[nums[end]]++;
            while (end - start + 1 - count[1] > 1) {
                count[nums[start]]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen - 1;
    }
}