class Solution {
    class Trie {
        Trie[] children;
        List<String> words;

        public Trie() {
            this.children = new Trie[26];
            this.words = new ArrayList();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root = new Trie();

        for (String product : products) {
            Trie cur = root;
            for (char c : product.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                if (cur.children[c - 'a'].words.size() < 3) {
                    cur.children[c - 'a'].words.add(product);
                }
                cur = cur.children[c-'a'];
            }
        }

        Trie node = root;
        List<List<String>> res = new ArrayList();
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (node.children[c - 'a'] == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    res.add(Collections.emptyList());
                }
                break;
            } else {
                res.add(node.children[c-'a'].words);
                node = node.children[c-'a'];
            }
        }

        return res;
    }
}