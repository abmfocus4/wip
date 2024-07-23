
// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/solutions/1458499/c-backtrack-c-users-please-pass-string-by-reference-to-pass
// https://www.youtube.com/watch?v=aoHbYlO8vDg&ab_channel=NeetCode
class Solution {
    int result = 0;
    
    public boolean isPalin(String s){
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
    
    public void dfs(String s, int i, StringBuilder s1, StringBuilder s2){
        
        if(i >= s.length()){
            if(isPalin(s1.toString()) && isPalin(s2.toString()))
                result = Math.max(result, s1.length() * s2.length());
            return;
        }
        
        s1.append(s.charAt(i));
        dfs(s, i+1, s1, s2);
        s1.deleteCharAt(s1.length() - 1);
        
        s2.append(s.charAt(i));
        dfs(s, i+1, s1, s2);
        s2.deleteCharAt(s2.length() - 1);
        
        dfs(s, i+1, s1, s2);
    }
    
    public int maxProduct(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        dfs(s, 0, s1, s2);
        
        return result;
    }
}
