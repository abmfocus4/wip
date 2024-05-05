class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        // s is subsequence of t
        if (s.length() > t.length()) return false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) j++;
            if (j == s.length()) return true;
        }
        return false;
    }
}