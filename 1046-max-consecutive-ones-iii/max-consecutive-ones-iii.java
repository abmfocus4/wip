class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] count_arr = new int[2];
        int max_len = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            count_arr[nums[end]]++;

            while (end - start + 1 - count_arr[1] > k) {
                count_arr[nums[start]]--;
                start++;
            }
            max_len = Math.max(max_len, end - start + 1);
        }
        return max_len;
    }
}