class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        if (p == null ^ s == null) return false;
        int m = s.length();
        int n = p.length();
        this.memo = new Boolean[m+1][n+1];
        return isMatch(0, 0, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // is next char in p * - take or don't take
        // is not, first char is matched

        boolean charMatched = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j+1 < p.length() && p.charAt(j + 1) == '*') {
            boolean take = charMatched && isMatch(i+1, j, s, p);
            boolean noTake = isMatch(i, j+2, s, p);
            return memo[i][j] = take || noTake;
        } else {
            return memo[i][j] = charMatched && isMatch(i+1, j+1, s, p);
        }
    }
}