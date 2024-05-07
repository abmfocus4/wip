// https://leetcode.com/problems/search-suggestions-system/solutions/440474/java-trie-explained-clean-code-14ms
class Solution {
    class Trie {
        Trie[] children;
        List<String> words;
        public Trie() {
            children = new Trie[26];
            words = new ArrayList();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // sort ascending order

        // add to trie
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
                cur = cur.children[c - 'a'];
            }
        }

        List<List<String>> res = new ArrayList();
        Trie cur = root;
        for (int i = 0; i < searchWord.length(); i++) {
            if (cur.children[searchWord.charAt(i) - 'a'] == null) {
                for (int j = i; j < searchWord.length(); j++)
                    res.add(Collections.emptyList());
                break;
            } else {
                res.add(cur.children[searchWord.charAt(i) - 'a'].words);
            }
            cur = cur.children[searchWord.charAt(i) - 'a'];
        }

        return res;

    }
}