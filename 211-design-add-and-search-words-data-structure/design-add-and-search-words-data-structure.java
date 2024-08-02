class Trie {
    Map<Character, Trie> children;
    boolean isWord;
    Trie() {
        this.children = new HashMap();
        this.isWord = false;
    }
}
class WordDictionary {
    Trie root;
    public WordDictionary() {
        this.root = new Trie();
    }
    
    public void addWord(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.containsKey(c) == false) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int curIdx, Trie node) {
        Trie cur = node;
        for (int i = curIdx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // match with all letters and see which one return true
                for (char child : cur.children.keySet()) {
                    if (search(word, i+1, cur.children.get(child)) == true) {
                        return true;
                    }
                }
                return false;
            } else  {
                if (cur.children.containsKey(c) == false) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */