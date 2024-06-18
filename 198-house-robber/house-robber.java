class Solution {
    // x(prev-prev) y(prev) z
    public int rob(int[] nums) {
        int prev_prev = 0;
        int prev = 0;

        for (int num : nums) {
            int cur = Math.max(num + prev_prev, prev); // rob current house or not rob
            prev_prev = prev;
            prev = cur;
        }

        return Math.max(prev, prev_prev);

    }
}