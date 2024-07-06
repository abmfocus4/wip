class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp(i, j): does text[i:] and pattern[j:] match
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match =
                    (i < text.length() && (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    boolean notTake = dp[i][j + 2];
                    boolean take = (first_match && dp[i + 1][j]);
                    dp[i][j] =  notTake || take;
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}