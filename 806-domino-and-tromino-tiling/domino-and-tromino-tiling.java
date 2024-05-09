// https://www.youtube.com/watch?v=7cijrfUkQzc
class Solution {
    public int numTilings(int n) {
        if (n <= 2) return n; 
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2*dp[i-1]%mod + dp[i-3] % mod) % mod;
        }
        
        return dp[n];
    }
}