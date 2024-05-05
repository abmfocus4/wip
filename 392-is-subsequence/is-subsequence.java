// converting s and t to char array and iterating is faster
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        // s is subsequence of t
        if (s.length() > t.length()) return false;
        char[] s_str = s.toCharArray();
        char[] t_str = t.toCharArray();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t_str[i] == s_str[j]) j++;
            if (j == s.length()) return true;
        }
        return false;
    }
}