// https://www.youtube.com/watch?v=3vbBrl-LeDc - Brute Force video
class Solution {
    public boolean isMatch(String text, String pattern) {
        if(text == null && pattern == null) return true;
        if(text == null || pattern == null) return false;

        // + 1 to account for empty string case
        Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];

        return isMatch(0, 0, text, pattern, memo);
        // possible scenarios
        
        // 1) char match with .
        // 2) char match with char
        // 3) c*/.*
    }

    private boolean isMatch(int i, int j, String text, String pattern, Boolean[][] memo) {
    // finished matching all characters, both need to go out of bound        
        if (j == pattern.length()) {
            return i == text.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean isFirstCharMatch = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        boolean hasMatched = false;
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            boolean repeatMultiple = isFirstCharMatch && isMatch(i + 1, j, text, pattern, memo); // repeat multiple
            boolean repeatZero = isMatch(i, j + 2, text, pattern, memo); // repeat 0
            hasMatched = repeatMultiple || repeatZero;
        } else {
            hasMatched = isFirstCharMatch && isMatch(i + 1, j + 1, text, pattern, memo);
        }
        return memo[i][j] = hasMatched;
    }
}