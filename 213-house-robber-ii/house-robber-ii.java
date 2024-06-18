class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n < 2)
            return n != 0 ? nums[0] : 0;
        int skipFirstHouseMax = robRow(nums, 1, n);
        int skipLastHouseMax = robRow(nums, 0, n - 1);

        return Math.max(skipFirstHouseMax, skipLastHouseMax);
    }

    public int robRow(int[] nums, int start, int end) {
        int prev_prev = 0, prev = 0;
        for (int i = start; i < end; i++) {
            int cur = Math.max(nums[i] + prev_prev, prev);
            prev_prev = prev;
            prev = cur;
        }

        return Math.max(prev_prev, prev);
    }
}