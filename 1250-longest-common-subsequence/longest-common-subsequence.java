// Space Optimizations: https://leetcode.com/problems/longest-common-subsequence/?envType=list&envId=pxw54vnt
// Code with explanation indexes
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (n>m) return longestCommonSubsequence(text2, text1);
        int[] dp = new int[n+1];
        for (int i = 0; i < m; i++) {
            int prevRow = 0, prevRowCol = 0;
            for (int j = 0; j < n; j++) {
                prevRowCol = prevRow;
                prevRow = dp[j+1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j+1] = prevRowCol + 1;
                } else {
                    dp[j+1] = Math.max(dp[j], prevRow);
                }
            }
        }
        return dp[n];
    }
}