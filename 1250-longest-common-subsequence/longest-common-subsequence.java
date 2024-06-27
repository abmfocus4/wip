// https://www.youtube.com/watch?v=e9tUPwZZSBI&ab_channel=NikhilLohia
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        // for (int[] row : dp) {
            Arrays.fill(dp, 0);
        // }



        int M = text1.length();
        int N = text2.length();

        for (int i = 1; i <= M; i++) {
            int pre = dp[0];
            dp[0] = 0;
            for (int j = 1; j <= N; j++) {
                int temp = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = 1 + pre;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = temp;
            }
        }

        return dp[N];
    }
}