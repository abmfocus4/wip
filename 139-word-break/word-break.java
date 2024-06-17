class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Trie Tree
        class Trie {
            HashMap<Character, Trie> children;
            boolean isWord;

            public Trie() {
                this.children = new HashMap();
                this.isWord = false;
            }
        }

        Trie root = new Trie();

        // insert all words in wordDict in Tree
        for (String word : wordDict) {
            Trie cur = root;
            for (Character c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }

        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i-1]) {
                Trie cur = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!cur.children.containsKey(c)) break;
                    cur = cur.children.get(c);
                    if (cur.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}