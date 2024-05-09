// https://www.youtube.com/watch?v=7cijrfUkQzc
class Solution {
    public int numTilings(int n) {
        if (n <= 2) return n; 
        if (n == 3) return 5;
        int dp_prev_prev_prev = 1;
        int dp_prev_prev = 2;
        int dp_prev = 5;
        int dp_n = 0;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp_n = (2*dp_prev%mod + dp_prev_prev_prev % mod) % mod;
            dp_prev_prev_prev = dp_prev_prev;
            dp_prev_prev = dp_prev;
            dp_prev = dp_n;
        }
        
        return dp_n;
    }
}