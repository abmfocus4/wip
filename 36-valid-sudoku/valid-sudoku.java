class Solution {
    int ROWS = 9;
    int COLS = 9;
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String rowStr = (board[i][j]) + "_ROW_" + i;
                String colStr = (board[i][j]) + "_COL_" + j;
                String boxStr = (board[i][j]) + "_BOX_" + i/3 + "_" + j/3;
                if (set.contains(rowStr) || set.contains(colStr) || set.contains(boxStr)) {
                    return false;
                }

                set.add(rowStr);
                set.add(colStr);
                set.add(boxStr);
            }
        }
        return true;
    }
}