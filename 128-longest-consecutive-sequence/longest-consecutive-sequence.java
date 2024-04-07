class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int longestLength = 0;
        int currentLength = 1; // err: init to 1 since one element in streak
        int streakStart = nums[0];
        for (int num : nums) {
            if (streakStart == num) { // starting streak
                continue;
            } else if (num == streakStart + 1) { // continue streak // err: next number is consecutive number of streak start
                streakStart++;
                currentLength++;
            } else { // streak reset
                streakStart = num;
                longestLength = Math.max(longestLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(longestLength, currentLength);
    }
}