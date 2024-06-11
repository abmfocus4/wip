class Solution {
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle) {
        int[] lps = getLPS(needle);
        int n = haystack.length(), m = needle.length();
        for (int i = 0, j = 0; i < n; i++) { // only move one way in primary string
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) j = lps[j-1]; // only j moves
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j;
            }
            if (j == m) return (i - j + 1);
        }
        return -1;
    }

    private int[] getLPS(String haystack) {
        int m = haystack.length();
        int[] lps = new int[m];
        for (int i = 1, j = 0; i < m; i++) { // pi table or lps table
            while (haystack.charAt(i) != haystack.charAt(j) && j > 0) j = lps[j-1];
            if (haystack.charAt(i) == haystack.charAt(j)) {
                lps[i] = ++j;
            }
            
        }
        return lps;
    }
}