class Solution {
    // create TrieNode ds
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>(26); // only 26 lowercase chars accepted
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // insert words in wordDict into trie
        // Time: O(mk)
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root; // for each word start insertion from root
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode()); // check if char of word exists in TrieNode or else create
                curr = curr.children.get(c);
            }
            curr.isWord = true; // once word is finished set isWord to True
        }
            
        // init dp DS
        boolean[] dp = new boolean[s.length()];
        // interate over all chars of s
        // Time: O(n^2)
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {  // check if index is 0 or dp[i-1] word breaks
                TrieNode curr = root; // for each index start at root of Trie to do wordSearch
                for (int j = i; j < s.length(); j++) { // iterate over i to end of string indexes to find word
                    // for each char in s, check if child exists, break if it does not
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) break; // check if char of word exists, if not, break, word does not exist
                    curr = curr.children.get(c); // update node to next node
                    if (curr.isWord) dp[j] = true; // if node is word is true, update dp
                }
            }
        }
        return dp[s.length() - 1]; // return dp for last index
    } 
}