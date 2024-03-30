class Solution {
    public String longestPalindrome(String s) {
        // for each substring (in descending)
        // if is palindrome : return substr
        
        for (int len = s.length(); len > 0; len--) {
            for (int start = 0; start <= s.length() - len; start++) {
                if (isPalindrome(s, start, start+len)) {
                    return s.substring(start, start+len);
                }
            }
        }
        return "";
    }

    public boolean isPalindrome(String s, int left, int right) {
        int i = left;
        int j = right - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}