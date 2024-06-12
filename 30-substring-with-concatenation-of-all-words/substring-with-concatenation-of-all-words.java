class Solution {
    String s;

    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        Trie trie = new Trie(words);
        List<Integer> res = new ArrayList<>();
        int concatStrLength =  (words.length*words[0].length());
        for (int i = 0; i <= s.length() - concatStrLength; i++) {
            if (trie.dfs(i, trie.root) >= words.length) {
                res.add(i);
            }
        }
        return res;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        int wordCount;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
            wordCount = 0;
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String word : words)
                insert(word);
        }

        public void insert(String s) {
            TrieNode cur = root;
            for (char ch : s.toCharArray()) {
                TrieNode node = cur.children.get(ch);
                if (node == null) {
                    node = new TrieNode();
                    cur.children.put(ch, node);
                }
                cur = node;
            }
            cur.wordCount++;
            cur.endOfWord = true;
        }

        public int dfs(int idx, TrieNode node) {
            if (idx >= s.length() || node == null)
                return 0;
            char ch = s.charAt(idx);
            TrieNode cur = node.children.get(ch);
            if (cur == null)
                return 0;
            if (cur.endOfWord && cur.wordCount > 0) {
                cur.wordCount--;
                int res = 1 + dfs(idx + 1, root);
                cur.wordCount++; // backtrack
                return res;
            }
            return dfs(idx + 1, cur); // continue with current node
        }
    }
}