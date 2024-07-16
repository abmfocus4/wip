// This problem is simple if you think it as min curCost path from source to destination.

// Build a graph by connecting all 4 adjacent edges.
// Assign wieght 0 to u to v if given direction in grid is u to v, other assign wieght 1( modify sign ).
// Apply Dijkstra algo on graph to find min curCost from (0,0) to (n,m),

class Solution {
    int[][] dirs = new int[][] {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((u, v) -> Integer.compare(u[2], v[2]));
        pq.add(new int[] { 0, 0, 0 }); // i, j, curCost

        while (!pq.isEmpty()) {
            int curRow = pq.peek()[0];
            int curCol = pq.peek()[1];
            int curCost = pq.peek()[2];
            pq.poll();

            if (curRow == grid.length - 1 && curCol == grid[0].length - 1)
                return curCost;

            if (curRow < 0 || curCol < 0 || curRow >= grid.length || curCol >= grid[0].length || grid[curRow][curCol] == 0)
                continue;

            int cell = grid[curRow][curCol];
            grid[curRow][curCol] = 0; // visited = true

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nr = curRow + dir[0];
                int nc = curCol + dir[1];
                int ncost = curCost + (cell - 1 == i ? 0 : 1); // if moving in same direction: add 0 or else add 1
                pq.add(new int[] { nr, nc, ncost });
            }
        }
        // ~ unreachable
        return Integer.MAX_VALUE;
    }
}