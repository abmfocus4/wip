// Ref: https://leetcode.com/problems/number-of-islands/solutions/56338/java-dfs-and-bfs-solution/comments/278802
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        // boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.offer(new int[]{i, j});
                    // visited[i][j] = true;
                    BFS(i, j, grid, q);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void BFS(int i, int j, char[][] grid, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0], y = curr[1] + dir[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length|| grid[x][y] == '0') {
                    continue;
                }
                grid[x][y] = '0';
                q.offer(new int[] {x, y});
            }
        }
    }
}