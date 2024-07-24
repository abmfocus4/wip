class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        // s[i] match with p[j]
        // 1. char to char
        // 2. char to .
        // 3. char to .*/c*
        this.memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean matchesCurrentChar = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // c* and .*
        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            boolean takeZero = isMatch(s, p, i, j+2);
            boolean takeMultiple = matchesCurrentChar && isMatch(s, p, i+1, j);
            return memo[i][j] = takeZero || takeMultiple;
        } else {
            // char match
            return memo[i][j] = matchesCurrentChar && isMatch(s, p, i+1, j+1);
        }
    }
}