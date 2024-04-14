class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestStreak = 0;
        int currentStreak = 1;
        int curNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curNum) {
                continue;
            } else if (nums[i] == curNum + 1) {
                currentStreak++;
                curNum++;
            } else {
                longestStreak = Math.max(longestStreak, currentStreak);
                curNum = nums[i];
                currentStreak = 1;
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}