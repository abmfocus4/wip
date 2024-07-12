// Ref: https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/1725207/java-simulation-complete-explanation-brute-force-optimised-solution/?envType=list&envId=pxw54vnt
// Idea: Modified Trie data structure (handling of '.')

class Node {
    HashMap<Character, Node> children;
    boolean isWord;
    Node() {
        this.children = new HashMap();
        this.isWord = false;
    }
}

class WordDictionary {
    private Node root;
    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = this.root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    public boolean search(String word, Node root, int idx) {
        Node cur = root;
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char ch : cur.children.keySet()) {
                    if (search(word, cur.children.get(ch), i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
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