class Solution {
    public String longestPalindrome(String s) {
        // use 2d array with row = start and column = end bounds of palindrome
        // base cases:
        // odd length palindrome reflected around i
        // even length palindromes reflected around i+1 (non char center)
        // dp : s[i] == s[j] && dp[i+1][j-1]

        int[] bounds = new int[] {0,0};
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] = true;
                bounds[0] = i;
                bounds[1] = i+1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i+diff;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    bounds[0] = i;
                    bounds[1] = j;
                }
            }
        }

        return s.substring(bounds[0], bounds[1]+1);

    }
}