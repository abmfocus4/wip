class Solution {
    int n;

    private int[] getCoord(int num) {
        int rt = (num-1)/n;
        int rb = (n - 1) - rt;
        int col = (num-1)%n;

        if ((rb % 2 == 0 && n % 2 == 0) || rb % 2 == 1 && n % 2 == 1) {
            col = (n - 1) - col;
        }

        return new int[] {rb, col};
    }
    public int snakesAndLadders(int[][] board) {
        // simple bfs
        // each level 6 rolls or look for ladder/snake
        this.n = board.length;

        Queue<Integer> q = new LinkedList();
        boolean[][] visited = new boolean[n][n];

        q.add(1);
        visited[n-1][0] = true;

        int steps = 0;
        while(q.isEmpty() == false) {
            int levelSize = q.size();

            while (levelSize-- > 0) {
                int cell = q.poll();
                if (cell == n*n) {
                    return steps;
                }
                for (int i = 1; i <= 6; i++) {
                    if (cell + i > n*n) break;

                    int[] coord = getCoord(cell + i);
                    int row = coord[0];
                    int col = coord[1];

                    if (visited[row][col]) continue;

                    visited[row][col] = true;
                    if (board[row][col] == -1) {
                        q.add(cell + i);
                    } else {
                        q.add(board[row][col]);
                    }
                }
            }

            steps++;    
        }

        return -1;

    }
}