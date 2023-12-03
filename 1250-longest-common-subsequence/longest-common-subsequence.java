// Explanation: https://www.youtube.com/watch?v=e9tUPwZZSBI
// Code: https://www.youtube.com/watch?v=9TZBo139Vlo

// Time/Space: O(mn)
class Solution {
    String text1;
    String text2;
    Integer[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int t1 = text1.length();
        int t2 = text2.length();
        this.cache = new Integer[t1+1][t2+1];
        return helper(t1, t2);
    }

    private int helper(int t1, int t2) {
        if (t1 == 0 || t2 == 0) return 0; // null string case
        if (cache[t1][t2] != null) return cache[t1][t2]; // return repeated cal
        if (text1.charAt(t1-1) == text2.charAt(t2-1)) { // adding char that will increase len of pre cal subseq
            cache[t1][t2] = 1 + helper(t1-1, t2-1);
        } else {
            cache[t1][t2] = Math.max(helper(t1-1, t2), helper(t1, t2-1));
        }
        return cache[t1][t2];
    }
}