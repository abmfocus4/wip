class Solution {
    int[][] dirs = {{1,0} , {0,-1}, {-1, 0}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int fresh = 0;
        int mins = 0;

        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) {
            return 0;
        }

        mins = 1;
        while (q.isEmpty() == false) {
            int levelSize = q.size();
            while(levelSize-- > 0) {
                int[] coord = q.poll();
                for (int[] dir : dirs) {
                    int x = coord[0] + dir[0];
                    int y = coord[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        q.add(new int[] {x, y});
                        grid[x][y] = 2;
                        fresh--;
                        if (fresh == 0) {
                            return mins;
                        }
                    }
                }
            }
            mins++;
        }

        return -1;
    }
}