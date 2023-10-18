class Solution {
    String s;
    List<String> wordDict;
    int[] memo; // stands for memoization
    private boolean dp(int i) { // calculate dp states
        if (i < 0) return true; // boundary checking/ edge case
        if (memo[i] != -1) return memo[i] == 1; // don't calculate case more than once

        for (String word : wordDict) { // check all words in dict
            if (i < word.length() - 1) continue; // boundary checking

            // actual dp case
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        // negative state
        memo[i] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1); // init with starting value (different from 1 and 0)
        return dp(s.length() - 1); // we want to check if last index passed uses all words in dict
    }
}