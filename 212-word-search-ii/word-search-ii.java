class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList();

        Trie root = new Trie(words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, Trie cur, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || cur.children.containsKey(board[i][j]) == false) {
            return;
        }

        char c = board[i][j];
        cur = cur.children.get(c);
        if (cur.isWord && cur.word != null) {
            res.add(cur.word);
            cur.isWord = false;
            cur.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, cur, res);
        dfs(board, i, j + 1, cur, res);
        dfs(board, i, j - 1, cur, res);
        dfs(board, i - 1, j, cur, res);
        board[i][j] = c;
    }

    class Trie {
        boolean isWord;
        String word;
        HashMap<Character, Trie> children;

        Trie() {
            this.isWord = false;
            this.word = null;
            this.children = new HashMap();
        }

        Trie(String[] words) {
            this.isWord = false;
            this.word = null;
            this.children = new HashMap();
            buildTree(this, words);
        }

        void buildTree(Trie root, String[] words) {
            for (String word : words) {
                Trie cur = root;
                for (char c : word.toCharArray()) {
                    if (cur.children.containsKey(c) == false) {
                        cur.children.put(c, new Trie());
                    }
                    cur = cur.children.get(c);
                }
                cur.isWord = true;
                cur.word = word;
            }
        }
    }
}