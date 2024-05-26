// https://www.youtube.com/watch?v=dGZjzA9zLW8&ab_channel=codestorywithMIK
class Solution {
    int ROWS = 9;
    int COLS = 9;
    public boolean isValidSudoku(char[][] board) {
        // ROWS is 9 and COLS is 9
        // validate ROWS
        // validate COLS
        // validate boxes


        // validate rows
        for (int row = 0; row < ROWS; row++) {
            HashSet<Character> set = new HashSet();
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (set.contains(board[row][col])) {
                    return false;
                }

                set.add(board[row][col]);
            }
        }

        // validate cols
        for (int col = 0; col < COLS; col++) {
            HashSet<Character> set = new HashSet();
            for (int row = 0; row < ROWS; row++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (set.contains(board[row][col])) {
                    return false;
                }

                set.add(board[row][col]);
            }
        } 

        // validate boxes
        for (int sr = 0; sr < ROWS; sr+=3) {
            int er = sr + 2;
            for (int sc = 0; sc < COLS; sc+=3) {
                int ec = sc + 2;
                if (validateBox(board, sr, er, sc, ec) == false) {
                    return false;
                }
            } 
        }

        return true; // checked everything, no discrepancies
    }

    private boolean validateBox(char[][] board, int sr, int er, int sc, int ec) {
        HashSet<Character> set = new HashSet();
        for (int row = sr; row <= er; row++) {
            for (int col = sc; col <= ec; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (set.contains(board[row][col])) {
                    return false;
                }

                set.add(board[row][col]);
            }
        }
        return true;
    } 
}