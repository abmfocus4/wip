// https://www.youtube.com/watch?v=e9tUPwZZSBI&ab_channel=NikhilLohia
// improvement: https://leetcode.com/problems/longest-common-subsequence/solutions/351689/java-python-3-two-dp-codes-of-o-mn-o-min-m-n-spaces-w-picture-and-analysis
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, 0);
        // }
        int M = text1.length();
        int N = text2.length();

        int prevRow;
        int prevRowCol;

        int[] dp = new int[N+1];
        Arrays.fill(dp, 0);

        for (int i = 1; i <= M; i++) {
            prevRow = 0;
            prevRowCol = 0;
            for (int j = 1; j <= N; j++) {
                prevRowCol = prevRow;
                prevRow = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = 1 + prevRowCol;
                } else {
                    dp[j] = Math.max(prevRow, dp[j-1]);
                }
            }
        }

        return dp[N];
    }
}