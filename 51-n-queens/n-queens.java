class Solution {
    public List<List<String>> solveNQueens(int n) {
        //backtrack
        //go col by col
        //check if we can place a queen
        //recurse

        // optimize - use bit map int for - top left, left, bottom left

        // prepare empty board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.'); // initially all rows are empty
        } 

        List<List<String>> result = new ArrayList();

        backtrack(n, result, 0, board);

        return result;
    }

    private void backtrack(int n, List<List<String>> result, int col, char[][] board) {
        if (col == n) {
            result.add(stringBoard(board));
            return;
        }

    // place queen in each col
    // interate each row
        for (int row = 0; row < n; row++) {
            if (canPlaceQueen(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(n, result, col+1, board); // increment col here
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlaceQueen(int row, int col, char[][] board, int n) {
        int dummyCol = col;
        // check left
        while (dummyCol >= 0) {
            if (board[row][dummyCol] == 'Q') {
                return false;
            }
            dummyCol--;
        }
        dummyCol = col;
        int dummyRow = row;
        // check upper diagnal
        while (dummyRow >= 0 && dummyCol >= 0) {
            if (board[dummyRow][dummyCol] == 'Q') {
                return false;
            }
            dummyCol--;
            dummyRow--;
        }

        // check lower diagnal // row increase, col decrease
        dummyCol = col;
        dummyRow = row;
        while (dummyCol >= 0 && dummyRow < n) {
            if (board[dummyRow][dummyCol] == 'Q') {
                return false;
            }
            dummyCol--;
            dummyRow++;
        }

        return true;
    }

    private List<String> stringBoard(char[][] board) {
        List<String> strBoard = new ArrayList();

        for (char[] row : board) {
            strBoard.add(new String(row));
        }

        return strBoard;
    }
}