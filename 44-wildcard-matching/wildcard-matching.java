class Solution {
    public boolean isMatch(String s, String p) {

        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return isMatch(0, 0, s, p, memo);

    }

    public boolean isMatch(int i, int j, String s, String p, Boolean[][] memo) {
        if (p.length() == j) {
            return s.length() == i;
        }

        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*')
                j++;
            return j == p.length();
        }

        // if(j == p.length() && i !=s.length()) return false;

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean res = false;
        
        if (p.charAt(j) == '*') {
            res = isMatch(i + 1, j + 1, s, p, memo) || 
                    isMatch(i + 1, j, s, p, memo) || 
                    isMatch(i, j + 1, s, p, memo);
        } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            res = isMatch(i + 1, j + 1, s, p, memo);
        }
        
        memo[i][j] = res;
        return res;
    }
}