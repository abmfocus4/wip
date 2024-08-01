class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    class State {
        int row;
        int col;
        int steps;

        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        // start bfs from each 0
        // increment step from each cur state
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<State> q = new LinkedList();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = mat[i][j];
                if (mat[i][j] == 0) {
                    q.add(new State(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }

        while (q.isEmpty() == false) {
            State cur = q.poll();
            int curRow = cur.row, curCol = cur.col, curSteps = cur.steps;
            for (int[] dir : dirs) {
                int newRow = dir[0] + curRow, newCol = dir[1] + curCol;
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && seen[newRow][newCol] == false) {
                    seen[newRow][newCol] = true;
                    result[newRow][newCol] = curSteps + 1;
                    q.add(new State(newRow, newCol, curSteps + 1));
                }
            }
        }

        return result;
    }
}