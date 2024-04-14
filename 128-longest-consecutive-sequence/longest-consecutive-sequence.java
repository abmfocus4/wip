class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int longestStreak = 0;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    nextNum++;
                }
                longestStreak = Math.max(longestStreak, nextNum - num);
            }
        }
        return longestStreak;
    }
}