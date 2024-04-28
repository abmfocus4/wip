// https://www.youtube.com/watch?v=e9tUPwZZSBI&ab_channel=NikhilLohia
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        int M = text1.length();
        int N = text2.length();

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[M][N];
    }
}