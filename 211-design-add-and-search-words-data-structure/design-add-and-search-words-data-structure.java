class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        this.isWord = false;
        this.children = new HashMap();
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c) == false) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }
    
    public boolean search(String word, TrieNode node, int index) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char ch : node.children.keySet()) {
                    if (search(word, node.children.get(ch), i+1)) // not index + 1
                        return true;
                }
                return false;
            } else {
                if (node.children.containsKey(c) == false) {
                    return false;
                }
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */