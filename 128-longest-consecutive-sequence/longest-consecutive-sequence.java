class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    nextNum++;
                }
                longestLength = Math.max(longestLength, nextNum - num);
            }
        }
        return longestLength;
    }
}