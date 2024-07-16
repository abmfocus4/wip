class Solution {
    int[][] steps = new int[][] {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((u, v) -> Integer.compare(u[2], v[2]));
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int cost = pq.peek()[2];
            pq.poll();

            if (r + 1 == grid.length && c + 1 == grid[0].length)
                return cost;

            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
                continue;
            int sign = grid[r][c];
            grid[r][c] = 0;

            for (int idx = 0; idx < steps.length; ++idx) {
                int nr = r + steps[idx][0];
                int nc = c + steps[idx][1];
                int ncost = cost + (sign == idx + 1 ? 0 : 1);
                pq.add(new int[] { nr, nc, ncost });
            }
        }
        // ~ unreachable
        return Integer.MAX_VALUE;
    }
}