class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        int[] count = new int[26];

        int start = 0;
        int end = 0;
        int largestCount = 0;

        for (end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            largestCount = Math.max(largestCount, count[s.charAt(end) - 'A']);

            while (end - start + 1 - largestCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}