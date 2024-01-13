class Solution {
    int[][] heights;
    int M;
    int N;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> res = new LinkedList();

        this.M = heights.length;
        this.N = heights[0].length;

        // dfs - reachable to pacific ocean
        boolean[][] pacificTable = new boolean[M][N];
        iterateRow(0, pacificTable);
        iterateCol(0, pacificTable);

        // dfs - reachable to atlantic ocean
        boolean[][] atlanticTable = new boolean[M][N];
        iterateRow(M-1, atlanticTable);
        iterateCol(N-1, atlanticTable);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (atlanticTable[i][j] == true && pacificTable[i][j] == true) {
                    res.add(Arrays.asList(new Integer[] { i , j}));
                }
            }
        }
        return res;
    }

    private void iterateRow(int row, boolean[][] visited) {
        int totalCols = N;
        for (int i = 0; i < totalCols; i++) {
            int col = i;
            dfs(row, col, visited);
        }
    }

    private void iterateCol(int col, boolean[][] visited) {
        int totalRows = M;
        for (int i = 0; i < totalRows; i++) {
            int row = i;
            dfs(row, col, visited);
        }
    }

    private void dfs(int row, int col, boolean[][] visited) {
        if (visited[row][col] == true) return;
        
        visited[row][col] = true;
        int curCellVal = heights[row][col];

        // Top
        if (row-1 >= 0 && curCellVal <= heights[row-1][col]) {
            dfs(row-1, col, visited);
        }

        // Down
        if (row+1 < M && curCellVal <= heights[row+1][col]) {
            dfs(row+1, col, visited);
        }

        // Left
        if (col-1 >= 0 && curCellVal <= heights[row][col-1]) {
            dfs(row, col-1, visited);
        }

        // Right
        if (col+1 < N && curCellVal <= heights[row][col+1]) {
            dfs(row, col+1, visited);
        }
    }
}