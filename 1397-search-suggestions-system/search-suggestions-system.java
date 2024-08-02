class Solution {
    class Trie {
        Map<Character, Trie> children;
        List<String> list;

        Trie() {
            this.children = new HashMap();
            this.list = new ArrayList();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        Trie root = new Trie();

        for (String product : products) {
            Trie cur = root;
            for (char c : product.toCharArray()) {
                if (cur.children.containsKey(c) == false) {
                    cur.children.put(c, new Trie());
                } 
                cur = cur.children.get(c);
                if (cur.list.size() < 3) {
                    cur.list.add(product);
                }
            }
        }

        List<List<String>> res = new ArrayList();
        Trie cur = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (cur.children.containsKey(c) == false) {
                for (int j = i; j < searchWord.length(); j++) {
                    res.add(new ArrayList());
                }
                return res;
            }
            cur = cur.children.get(c);
            res.add(cur.list);
        }

        return res;

    }
}