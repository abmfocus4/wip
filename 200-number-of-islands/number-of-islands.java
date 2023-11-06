// Ref DFS solution: https://leetcode.com/problems/number-of-islands/solutions/56338/java-dfs-and-bfs-solution/?envType=list&envId=pxw54vnt
// Ref DFS video: https://www.youtube.com/watch?v=U6-X_QOwPcs
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    private void DFS(int i, int j, char[][] grid) {
        // boundary checks
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; //set '1' to '0' so you don't visit it again
        DFS(i+1, j, grid); //up
        DFS(i-1, j, grid); //down
        DFS(i, j-1, grid); //left
        DFS(i, j+1, grid); //right
    }
}