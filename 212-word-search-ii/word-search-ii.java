// Time Comp Analysis: https://leetcode.com/problems/word-search-ii/solutions/59780/java-15ms-easiest-solution-100-00/comments/161749
// Code Ref: https://leetcode.com/problems/word-search-ii/solutions/156559/Java-(40ms)-Solution-with-Complexity-Analysis/
// Code Ref: https://leetcode.com/problems/word-search-ii/solutions/59780/java-15ms-easiest-solution-100-00/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words); // build prefix tree
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) { // start dfs at each location
            dfs(board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    // base case
    // return if out of bounds, if visited and if current cell is not a character in the trie
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || p.children.get(board[i][j]) == null) {
        return;
    }

    char c = board[i][j];
    p = p.children.get(c);
    if (p.word != null && p.isWord == true) {   // found one word
        res.add(p.word);
        p.word = null; // de-duplicate
        p.isWord = false; // de-duplicate
    }

    board[i][j] = '#'; // mark as visited alternatively use separate boolean[][] visited 2d arr
    dfs(board, i - 1, j ,p, res); 
    dfs(board, i, j - 1, p, res);
    dfs(board, i + 1, j, p, res); 
    dfs(board, i, j + 1, p, res); 
    board[i][j] = c; // backtrack
}

// The trie is represented by a root node, not a Trie object
private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
        curr.word = word; // Store a word at the leaf node
    }
    return root;
}

private class TrieNode {
    boolean isWord; // this.word is null if isEndOfWord is false
    String word; // Store the word so that no StringBuilder is needed to build the word char by char
    Map<Character, TrieNode> children;
    TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
        this.word = null; // de-duplicate
    }
}
}
