class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet set = new HashSet<>(wordDict); // O(mk)
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        // O(n3)
        for (int i = 0 ; i <= n; i++) { //O(n)
            for (int j = 0; j < i; j++) { // O(n)
                if (dp[j] && set.contains(s.substring(j, i))) { // O(n)
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}