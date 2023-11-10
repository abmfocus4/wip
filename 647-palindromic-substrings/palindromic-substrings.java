// Code Ref: https://leetcode.com/problems/palindromic-substrings/solutions/105689/java-solution-8-lines-extendpalindrome/comments/144768
// Idea is start from each index and try to extend palindrome for both odd and even length.
// Understanding: https://leetcode.com/problems/palindromic-substrings/solutions/105688/very-simple-java-solution-with-detail-explanation/?envType=list&envId=pxw54vnt
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendPalindrome(s, i, i); // odd length palindrome
            count += extendPalindrome(s, i , i+1); // even len palindrome
        }

        return count;
    }

    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}