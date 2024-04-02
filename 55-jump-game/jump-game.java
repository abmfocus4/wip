class Solution {
    public boolean canJump(int[] nums) {
        int target_pos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= target_pos - i) {
             target_pos = i;   
            }
        }
        return target_pos == 0;
    }
}