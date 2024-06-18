class Solution {
    // dfs (immediately explore neighbours)
    // bfs - add to queue, explore neighbours once all in level are added
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i+1, j, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i, j-1, grid);
    }
}