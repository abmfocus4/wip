class Solution {
    public List<List<String>> solveNQueens(int n) {
        // backtrack
        // go col by col
        // check if we can place a queen
        // recurse

        // optimize - use bit map int for - top left, left, bottom left

        // prepare empty board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.'); // initially all rows are empty
        }

        List<List<String>> result = new ArrayList();

        backtrack(n, result, 0, board, 0, 0, 0);

        return result;
    }

    private void backtrack(int n, List<List<String>> result, int col, char[][] board, int topLeft, int left, int bottomLeft) {
        if (col == n) {
            result.add(stringBoard(board));
            return;
        }

    // place queen in each col
    // interate each row
        for (int row = 0; row < n; row++) {
            // check top left, left, bottom left
            // if true proceed

            // calculate cur row, col hash
            // for left it's just row number
            // for topLeft = row - col + N (+N is for offsetting neg values)
            // for bottomLeft = row + col

            int curTopLeft = row - col;
            int curBottomLeft = row + col;
            int curLeft = row;

            if ((left & (1 << curLeft)) == 0 && (topLeft & (1 << curTopLeft)) == 0 && (bottomLeft & (1 << curBottomLeft)) == 0) {
                // update/set topleft, left, bottomleft
                left |= (1<<curLeft);
                topLeft |= (1<<curTopLeft);
                bottomLeft |= (1<<curBottomLeft);

                board[row][col] = 'Q';
                backtrack(n, result, col+1, board, topLeft, left, bottomLeft); // increment col here
                board[row][col] = '.';

                // undo/unset topleft, left, bottomleft
                left ^= (1<<curLeft);
                topLeft ^= (1<<curTopLeft);
                bottomLeft ^= (1<<curBottomLeft);
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