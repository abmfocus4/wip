// https://leetcode.com/problems/rotting-oranges/solutions/238681/java-clean-bfs-solution-with-comments
// classic bfs
class Solution {
    public static final int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        // Put the position of all rotten oranges in queue
        // mins the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        // if mins of fresh oranges is zero --> return 0
        if (count_fresh == 0)
            return 0;

        int mins = 0;
        // bfs starting from initially rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    // out of bounds
                    // if fresh orange is present
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        // put the new rotten orange at (x , y) in queue
                        queue.add(new int[] { x, y });
                        // mark the orange at (x , y) as rotten
                        grid[x][y] = 2;
                        // decrease the mins of fresh oranges by 1
                        count_fresh--;
                    }
                }
            }
            mins++; // level increase
        }
        // if all fresh oranges are removed then return result otherwise -1
        return count_fresh == 0 ? mins - 1 : -1;
    }
}