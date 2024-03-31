class Solution {
    public String longestPalindrome(String s) {
        int[] bounds = new int[] {0,0};
        for (int i = 0; i < s.length(); i++) {
            // consider odd length palindromes - n centers
            int oddLen = expand(s, i, i);
            if (oddLen > bounds[1] - bounds[0] + 1) {
                int dist = oddLen/2;
                bounds[0] = i - dist;
                bounds[1] = i + dist;
            }

            // consider even length palindromes - n-1 centers
            int evenLen = expand(s, i , i+1);
            if (evenLen > bounds[1] - bounds[0] + 1) {
                int dist = (evenLen/2) - 1;
                bounds[0] = i - dist;
                bounds[1] = i + dist + 1;
            }
        }

        return s.substring(bounds[0], bounds[1]+1);
    }

    private int expand(String s, int i, int j) {
        int left = i;
        int right = j;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}