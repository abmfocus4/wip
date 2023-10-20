class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length() - 1) continue;
                // check before first index of word in s, the string can word break
                // or if word is the first word of word break (so that dp of [i-word.length] does not become neg)
                if (i - word.length() + 1 == 0|| dp[i - word.length()]) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}