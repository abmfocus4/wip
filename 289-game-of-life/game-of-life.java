class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

    private int getLiveNeighbours(int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int neighRow = i + dir[0];
            int neighCol = j + dir[1];

            if (neighRow < 0 || neighCol < 0 || neighRow >= board.length || neighCol >= board[0].length) {
                continue;
            }

            int neighCell = board[neighRow][neighCol];

            if (neighCell == 1 || neighCell == 3) {
                count++;
            }
        }

        return count;

    }

    public void gameOfLife(int[][] board) {
        // live cell, live neighbours < 2; dies == 3
        // live cell; live neighbours = 3/4; lives
        // live cell; live neighbours > 3, dies == 3
        // dead cell, live neighbours == 3; lives == 4

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = board[i][j];
                int liveNeighbours = getLiveNeighbours(board, i, j);
                if (cell == 1 && (liveNeighbours < 2 || liveNeighbours > 3)) {
                    board[i][j] = 3;
                } else if (cell == 0 && liveNeighbours == 3) {
                    board[i][j] = 4;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }

        return;
    }
}