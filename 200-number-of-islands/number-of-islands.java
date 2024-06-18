class Solution {
    // dfs (immediately explore neighbours)
    // bfs - add to queue, explore neighbours once all in level are added
    boolean[][] visited;
    Queue<int[]> q;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        this.q = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new int[] {i, j});
                    grid[i][j] = '0';
                    bfs(i, j, grid);
                }
            }
        }

        return count;
    }
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public void bfs(int i, int j, char[][] grid) {
        while (q.isEmpty() == false) {
            int[] coord = q.poll();
            for (int[] dir : dirs) {
                int x = coord[0] + dir[0];
                int y = coord[1] + dir[1];
                if (x < 0 || y < 0 || y >= grid[0].length || x >= grid.length || grid[x][y] == '0') continue;
                q.add(new int[] {x, y});
                grid[x][y] = '0';
            }
        }

    }
}