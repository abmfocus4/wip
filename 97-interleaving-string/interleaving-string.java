class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); int len2 = s2.length(); int len3 = s3.length();
        // If simply adding length do not match len3, then there is no way we can forms
        // s3 by interleaving chars in s1,s2
        if(len1 + len2 != len3) {
            return false;
        }
        
        /*
        dp[i][j] -> true if s1[0..i-1] and s2[0..j-1] interleaves s3[0..i+j-1]
        */
        boolean[] dp = new boolean[len2+1];
        
        /*
        EMPTY s1,s2 can surely interleave to form EMPTY s3
        */
        dp[0] = true;
        
        /*
        If S1 is empty, then just check whether char in s2 matches with that of s3
        Note: i == 0 here.
        */
        for(int j = 1;j<=len2;j++) {
            dp[j] = dp[j-1] && s3.charAt(j-1) == s2.charAt(j-1);
        }
        
        /*
        Now check for both s1,s2 being non empty
        */
        for(int i = 1; i<=len1; i++) {
            boolean pre = dp[0];
            dp[0] = dp[0] && s3.charAt(i-1) == s1.charAt(i-1);
            for(int j = 1; j<=len2; j++) {
                boolean tmp = dp[j];
                // Characters to be compared
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                int c3 = s3.charAt(i + j - 1);
                
                // If c3 matches c1, then is every char before c1 in s1 valid?
                // If c3 matches c2, then is every char before c2 in s2 valid?
                dp[j] = (c1 == c3 && dp[j]) || (c2 == c3 && dp[j-1]);
                pre = tmp;
            }
        }
        
        return dp[len2];
    }
}