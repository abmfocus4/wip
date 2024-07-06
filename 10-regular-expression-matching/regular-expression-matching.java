// https://www.youtube.com/watch?v=3vbBrl-LeDc - Brute Force video
class Solution {
    public boolean isMatch(String text, String pattern) {
        if(text == null && pattern == null) return true;
        if(text == null || pattern == null) return false;

        return isMatch(0, 0, text, pattern);
        // possible scenarios
        
        // 1) char match with .
        // 2) char match with char
        // 3) c*/.*
    }

    private boolean isMatch(int i, int j, String text, String pattern) {
    // finished matching all characters, both need to go out of bound
        if (j == pattern.length()) {
            return i == text.length();
        }

        boolean isFirstCharMatch = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));


        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            boolean repeatMultiple = isFirstCharMatch && isMatch(i + 1, j, text, pattern); // repeat multiple
            boolean repeatZero = isMatch(i, j + 2, text, pattern); // repeat 0
            return repeatMultiple || repeatZero;
        } else {
            return isFirstCharMatch && isMatch(i + 1, j + 1, text, pattern);
        }
    }
}