class Solution {
    // Time: O(N^2)
    boolean visited[][]; // avoid repeatedly searching for the same element (using duplicate indexes)
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        int[] boardf = new int[128]; // frequency board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardf[board[i][j]]++; // using ascii directly
            }
        }

        char[] word_arr = word.toCharArray();

        for (char w : word_arr) {
            if (boardf[w]-- < 0) return false; // frequency doesn't match exit early
        }

        // reverse word if number of cells with starting letter is more than number of cells with ending letter (reverse or not result is same)
        if (boardf[word_arr[0]] > boardf[word_arr[word.length() - 1]]) {
            word = reverse(word);
        }

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && wordSearch(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean wordSearch(int i, int j, int index, char[][] board, String word) {
        // base cases
        if (index == word.length())  return true;

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || word.charAt(index) != board[i][j] || visited[i][j]) return false;

        // processing new index
        visited[i][j] = true;
        if (
            wordSearch(i, j-1, index+1, board, word) ||
            wordSearch(i, j+1, index+1, board, word) ||
            wordSearch(i-1, j, index+1, board, word) ||
            wordSearch(i+1, j, index+1, board, word)
        ) return true;

        // if you did not hit any conditions above
        visited[i][j] = false;
        return false;
    }

    public String reverse(String word) {
        int N = word.length();
        char[] word_arr = word.toCharArray();
        for (int i = 0; i < N/2; i++) {
            char temp = word_arr[i];
            word_arr[i] = word_arr[N - i - 1];
            word_arr[N-i-1] = temp;
        }
        return String.valueOf(word_arr);
    }
}