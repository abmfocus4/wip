import java.util.*;
//  O(n^2logn) time complexity
class Solution {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int ans = Math.max(grid[0][0], grid[n-1][n-1]); // min amount of time for 0,0 to be connected to last square
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        // int[0] = time, int[1], [2] = coord
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        
        int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0,-1}};
        pq.offer(new int[]{ans, 0, 0});

        // In every step, find lowest water level to move forward, so using PQ rather than queue
        while (!pq.isEmpty()) { // next available cell that you can explore
            int[] cur = pq.poll();
            ans = Math.max(ans, cur[0]);

            if (cur[1] == n - 1 && cur[2] == n - 1) return ans;
                
            for (int[] dir : dirs) { 
                int r = cur[1] + dir[0];
                int c = cur[2] + dir[1];
                
                if (r >= 0 && r < n && c >= 0 && c < n && visited[r][c] == 0) {
                    pq.offer(new int[]{grid[r][c], r, c}); // elevation you need to swim to this grid
                    visited[r][c] = 1;
                }
            }
        }
        
        return -1;
    }
}
