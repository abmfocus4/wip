// moving indexes and intuition: 
// https://www.youtube.com/watch?v=XYi2-LPrwm4&ab_channel=NeetCode

// https://www.youtube.com/watch?v=HwDXH35lr0o&ab_channel=NikhilLohia - table for bottom up approach
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) { // account for empty string
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1; // replace, insert, delete + 1 operation
                }
            }
        }

        return dp[m][n];
    }
}