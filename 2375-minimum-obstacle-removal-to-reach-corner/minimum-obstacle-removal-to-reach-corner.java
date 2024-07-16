// 0-1 bfs using dq
// add 0s to first
// add 1s to last
// since only two weights b/n nodes, don't need logN overhead of pq
class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dist = new int[m][n]; // obstacles needed to remove to get to m-1, n-1

        for (int[] di : dist) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.offer(new int[] { 0, 0, 0 });

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curRow = cur[0], curCol = cur[1], curCost = cur[2];
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                // add to q only valid coordinates
                if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && dist[newRow][newCol] == Integer.MAX_VALUE) {
                    int newCost = curCost + (grid[newRow][newCol] == 1 ? 1 : 0);
                    if (grid[newRow][newCol] == 1) {
                        dq.addLast(new int[] { newRow, newCol, newCost }); // larger cost add last
                    } else {
                        dq.addFirst(new int[] { newRow, newCol, newCost }); // smaller cost add first
                    }
                    dist[newRow][newCol] = curCost;
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}