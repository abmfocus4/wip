// https://www.youtube.com/watch?v=26IT3FYm5h8&ab_channel=codestorywithMIK
class Solution {
    int n;

    private int[] getCoordinate(int num) {
        int[] coord = new int[2];
        int rt = (num - 1) / n;
        int rb = (n - 1) - rt;

        int col = (num - 1) % n;

        if ((rb % 2 == 0 && n % 2 == 0) || (rb % 2 == 1 && n % 2 == 1)) { 
            // if both even or both odd (right to left order)
            col = (n - 1) - col;
        }

        coord[0] = rb;
        coord[1] = col;
        return coord;
    }

    public int snakesAndLadders(int[][] board) {
        // perform simple bfs
        // visited to stop repeatedly visiting the same cell
        this.n = board.length;

        boolean[][] visited = new boolean[n][n]; // if (r,c) is visited before
        Queue<Integer> q = new LinkedList(); // contains cell numbers
        visited[n - 1][0] = true;
        q.add(1);

        int steps = 0;
        while (q.isEmpty() == false) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int x = q.poll();
                if (x == n * n) { // pop and check
                    return steps;
                }
                for (int k = 1; k <= 6; k++) {
                    if (x + k > n * n) { // push only valid cell values
                        break;
                    }
                    int[] coord = getCoordinate(x + k);
                    int row = coord[0];
                    int col = coord[1];
                    if (visited[row][col] == true) { // check if visited before push
                        continue;
                    }
                    visited[row][col] = true; // mark as visited
                    if (board[row][col] == -1) { // push correct value
                        q.add(x + k);
                    } else {
                        q.add(board[row][col]);
                    }
                }
            }

            steps++; // after each level increase step
        }
        return -1; // haven't returned during bfs
    }
}