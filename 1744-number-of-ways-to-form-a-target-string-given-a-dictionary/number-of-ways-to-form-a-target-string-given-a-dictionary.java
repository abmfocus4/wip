class Solution {
    
    private int m;
    private int j;
    
    private int dp[][];
    private int mod;
    
    private int solve(long freq[][], String target, int i, int k) {
        
        if(i == m)
            return 1;
        
        if(k == j)
            return 0;
        
        if(dp[i][k] != -1)
            return dp[i][k];
        
        long notTaken = solve(freq,target,i,k+1) % mod;
        
        long taken =  (freq[target.charAt(i)-'a'][k] * solve(freq,target,i+1,k+1)) % mod;
        
        return dp[i][k] = (int)((notTaken + taken) % mod);  
    }
    
    public int numWays(String[] words, String target) {
        
        this.m = target.length();
        this.j = words[0].length();
        this.mod = 1000000007;
        
        this.dp = new int[m][j];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        long freq[][] = new long[26][j];
        
        for(int col=0; col<j; col++) {
            for(String word : words) {
                
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }
        
        return solve(freq, target, 0, 0);
    }
}