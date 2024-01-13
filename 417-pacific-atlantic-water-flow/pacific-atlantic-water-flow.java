// Ref : https://www.youtube.com/watch?v=ZQp1oGp1y6s
// BFS
class Solution {
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights; // init heights grid
        List<List<Integer>> res = new LinkedList();

        int M = heights.length; // row size
        int N = heights[0].length; // col size

        Queue<int[]> q = new LinkedList(); // q of coordinate int[]
        
        // bfs over pacific ocean
        addRow(0, q, N);
        addCol(0, q, M);
        boolean[][] pacificTable = bfs(q, M, N);

        // bfs over atlantic ocean
        addRow(M-1, q, N);
        addCol(N-1, q, M);
        boolean[][] atlanticTable = bfs(q, M, N);

        // check cells that can access both pacific and atlantic ocean
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (atlanticTable[i][j] == true && pacificTable[i][j] == true) {
                    res.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return res;
    }

    private void addRow(int row, Queue<int[]> q, int totalCols) {
        for (int i = 0; i < totalCols; i++) {
            int col = i;
            int[] coor = {row, col};
            q.add(coor);
        }
    }

    private void addCol(int col, Queue<int[]> q, int totalRows) {
        for (int i = 0; i < totalRows; i++) {
            int row = i;
            int[] coor = {row, col};
            q.add(coor);
        }
    }

    private boolean[][] bfs(Queue<int[]> q, int M, int N) {
        boolean[][] visited = new boolean[M][N];
        
        while (q.isEmpty() == false) {
            int[] first = q.poll();
            int row = first[0];
            int col = first[1];
            if (visited[row][col] == true) {
                continue;
            }
            visited[row][col] = true;
            int curCellVal = heights[row][col];
            
            // Top
            if (row - 1 >= 0 && curCellVal <= heights[row-1][col])
                q.add(new int[] {row-1, col});

            // Left
            if (col - 1 >= 0 && curCellVal <= heights[row][col-1])
                q.add(new int[] {row, col-1});

            // Right
            if (col + 1 < N && curCellVal <= heights[row][col+1])
                q.add(new int[] {row, col+1});

            // Down
            if (row + 1 < M && curCellVal <= heights[row+1][col])
                q.add(new int[] {row+1, col});
        }
        return visited;
    }
}