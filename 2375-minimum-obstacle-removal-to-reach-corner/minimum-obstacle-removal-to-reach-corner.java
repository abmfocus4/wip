class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int minimumObstacles(int[][] grid) {
        // djikstra
        // i, j, cost ()
        // grid[i][j] = -2 means visited

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((u, v) -> Integer.compare(u[2], v[2]));
        pq.add(new int[] {0, 0, 0});

        int m = grid.length;
        int n = grid[0].length;

        while (pq.isEmpty() == false) {
            int[] cur = pq.poll();
            int curRow = cur[0], curCol = cur[1], curCost = cur[2];

            if (curRow == m - 1 && curCol == n - 1) {
                return curCost;
            }

            if (curRow < 0 || curCol < 0 || curRow >= m || curCol >= n || grid[curRow][curCol] == -2) {
                continue;
            }

            int cell = grid[curRow][curCol];
            grid[curRow][curCol] = -2;

            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                int newCost = curCost + (cell == 1 ? 1 : 0);
                pq.add(new int[] {newRow, newCol, newCost}); 
            }
        }

        return Integer.MAX_VALUE;
    }
}