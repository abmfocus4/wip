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

class Solution {
    int m;
    int n;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        
        int[][] result = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<State> q = new LinkedList<>();
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = mat[row][col];
                if (mat[row][col] == 0) {
                    q.add(new State(row, col, 0));
                    seen[row][col] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            State state = q.poll();
            int row = state.row, col = state.col, steps = state.steps;
            
            for (int[] dir: dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    q.add(new State(nextRow, nextCol, steps + 1));
                    result[nextRow][nextCol] = steps + 1; // only gets updated for non zeros
                }
            }
        }
        
        return result;
    }
    
    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}