class Solution {
    public boolean exist(char[][] board, String word) {
        // iterate through 2d matrix
        // find first character of word cell
        // run dfs from there
        // use visited or update board
        int m = board.length;
        int n = board[0].length;

        int[] boardf = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardf[board[i][j]]++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (boardf[word.charAt(i)]-- < 0) {
                return false;
            }
        }

        // check frequency of first and last char in word and reverse
        if (boardf[word.charAt(0)] > boardf[word.charAt(word.length() - 1)]) {
            word = reverse(word);
        }
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private String reverse(String word) {
        char[] wordArr = word.toCharArray();
        int n = wordArr.length;
        for (int i = 0; i < n/2; i++) {
            char temp = wordArr[i];
            wordArr[i] = wordArr[n - i - 1];
            wordArr[n - i - 1] = temp;
        }
        return new String(wordArr);
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // basecase
        if (index ==  word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.' || word.charAt(index) != board[i][j]) {
            return false;
        }

        // iterate all directions
        char original = board[i][j];
        board[i][j] = '.';
        if (dfs(board, i + 1, j, word, index + 1) ||
            dfs(board, i, j + 1, word, index + 1) ||
            dfs(board, i - 1, j, word, index + 1) ||
            dfs(board, i, j - 1, word, index + 1)) {
                return true;
        }

        board[i][j] = original;
        return false;
    }
}