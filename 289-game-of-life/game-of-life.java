// https://www.youtube.com/watch?v=fei4bJQdBUQ&ab_channel=NeetCode
class Solution {
    // 1 -> 0 : < two 1s as neighbours // UPDATE
    // 1 -> 1 : two or three 1s as neighbours
    // 1 -> 0 : > three 1s as neighbours // UPDATE
    // 0 -> 1 : three 1s as neighbours // UPDATE
    int liveToDead = 2;
    int deadToLive = 3;

    int m, n;
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}}; // 9 neighbours
    private int getLiveNeighbours(int[][] board, int i, int j) {
        int liveNeighbours = 0;
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n) {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == liveToDead) {
                    // previous neighbours that are 1 before update
                    liveNeighbours++;
                }
            }
        }
        return liveNeighbours;
    }
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curCell = board[i][j];
                int liveNeighbours = getLiveNeighbours(board, i, j);
                if (board[i][j] == 0 && liveNeighbours == 3) {
                    board[i][j] = deadToLive;
                } else if (board[i][j] == 1) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        board[i][j] = liveToDead;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == deadToLive) {
                    board[i][j] = 1;
                } else if (board[i][j] == liveToDead) {
                    board[i][j] = 0;
                }
            }
        }
    }
}