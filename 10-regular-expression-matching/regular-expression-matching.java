class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null ^ s == null) return false;
        return isMatch(0, 0, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        if (j == p.length()) {
            return i == s.length();
        }

        // is next char in p * - take or don't take
        // is not, first char is matched

        boolean charMatched = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j+1 < p.length() && p.charAt(j + 1) == '*') {
            boolean take = charMatched && isMatch(i+1, j, s, p);
            boolean noTake = isMatch(i, j+2, s, p);
            return take || noTake;
        } else {
            return charMatched && isMatch(i+1, j+1, s, p);
        }
    }
}