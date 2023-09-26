class Solution {
    // dp solution
    // from the first element check the next jump elements can reach the last elements
    // backtracking involved
    // cacheing of results - at each index store if you can reach the last element from that index

    // nums = [2,3,1,1,4], nums.length = 5
    // index= [0,1,2,3,4]
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canJump(nums, 0, dp);
    }

    private boolean canJump(int[] nums, int index, int[] dp) {
        // current index is last index or greater (max jump)
        if (index >= nums.length - 1) {
            return true;
        }

        if (nums[index] == 0) {
            dp[index] = 0;
            return false;
        }

        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        int jumps = nums[index];
        for (int i = 1; i <= jumps; i++) {
            if (canJump(nums, index+i, dp)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }
}