class Solution {
    class Trie {
        Map<Character, Trie> children;
        boolean isWord;

        Trie() {
            this.children = new HashMap();
            this.isWord = false;
        }
    }

    private void insert(String str, Trie root) {
        Trie cur = root;
        for (char c : str.toCharArray()) {
            if (cur.children.containsKey(c) == false) {
                cur.children.put(c, new Trie());
            }

            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    public String longestCommonPrefix(String[] strs) {
        // add all strings to trie tree
        // traverse till keyset.size() == 1 and append key to string builder
        Trie root = new Trie();
        for (String str : strs) {
            insert(str, root);
        }

        StringBuilder sb = new StringBuilder();
        Trie cur = root;

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            if (cur.children.containsKey(c) && cur.children.size() == 1 && cur.isWord == false) {
                sb.append(c);
                char next = cur.children.keySet().iterator().next();
                cur = cur.children.get(next);
            } else {
                return sb.toString();
            }
        }

        return strs[0];
    }
}