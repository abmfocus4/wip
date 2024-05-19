// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/solutions/524886/java-c-python-bfs-and-dfs/comments/663095
class Solution {
    int rows, cols;
    int[][] dirs = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[rows][cols];
        moveTillYouCant(0, 0, q, grid, visited);

        int cost = 0;
        while (q.isEmpty() == false) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int[] curCell = q.poll();
                int curCellRow = curCell[0];
                int curCellCol = curCell[1];

                if (curCellRow == rows - 1 && curCellCol == cols - 1) {
                    return cost;
                }

                // try changing direction of current cell and check
                for (int[] dir : dirs) {
                    moveTillYouCant(curCellRow + dir[0], curCellCol + dir[1], q, grid, visited);
                }

            }

            cost++;
        }

        return -1;
    }

    private void moveTillYouCant(int row, int col, Queue<int[]> q, int[][]grid, boolean[][]visited) {
        while (row >= 0 && row < rows && col >= 0 && col < cols && visited[row][col] == false) {
            q.add(new int[] {row, col});
            visited[row][col] = true;
            int[] dir = dirs[(grid[row][col] - 1) % 4];
            row += dir[0];
            col += dir[1];
        }
    }
}