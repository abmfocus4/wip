class Solution {
    public boolean exist(char[][] board, String word) {
        // find the first letter and then find the word from there
        // use a 2d visited arr to make sure you are not revisiting already seen cells
        // frequency check opt
        // reverse word opt

        int rows = board.length;
        int cols = board[0].length;

        // frequency check
        int[] boardf = new int[128];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardf[board[i][j]]++;
            }
        }

        for (char c : word.toCharArray()) {
            if (boardf[c]-- < 0) return false;
        }

        // reverse opt
        if (boardf[word.charAt(0)] > boardf[word.charAt(word.length() - 1)]) {
            word = reverse(word);
        }

        boolean[][] visited = new boolean[rows][cols];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && wordSearch(i, j, 0, visited, board, word)) {
                    return true;
                }
            }
        }

        return false;
        
    }

    public boolean wordSearch(int i, int j, int index, boolean[][] visited, char[][] board, String word) {
        if (index == word.length()) return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j] || word.charAt(index) != board[i][j]) return false;
        visited[i][j] = true;
        if (wordSearch(i + 1, j, index + 1, visited, board, word) || wordSearch(i - 1, j, index + 1, visited, board, word)
                || wordSearch(i, j + 1, index + 1, visited, board, word)
                || wordSearch(i, j - 1, index + 1, visited, board, word)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public String reverse(String word) {
        int N = word.length();
        char[] word_arr = word.toCharArray();

        for (int i = 0; i < N/2; i ++) {
            char temp = word_arr[i];
            word_arr[i] = word_arr[N-i-1];
            word_arr[N-i-1] = temp;
        }

        return String.valueOf(word_arr);
    }
}