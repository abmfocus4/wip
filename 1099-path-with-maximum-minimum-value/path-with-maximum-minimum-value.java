class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maximumMinimumPath(int[][] grid) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(grid[b[0]][b[1]], grid[a[0]][a[1]]));
        pq.add(new int[] { 0, 0 });

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int ans = grid[0][0];

        while (!pq.isEmpty()) {
            int[] curCoord = pq.poll();
            int curRow = curCoord[0], curCol = curCoord[1];
            ans = Math.min(ans, grid[curRow][curCol]);
            if (curRow == m - 1 && curCol == n - 1) {
                break;
            }

            for (int[] dir : dirs) {
                int newRow = curRow + dir[0], newCol = curCol + dir[1];
                if (newRow >= 0 &&
                        newRow < m &&
                        newCol >= 0 &&
                        newCol < n &&
                        visited[newRow][newCol] == false) {
                    pq.offer(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return ans;
    }
}