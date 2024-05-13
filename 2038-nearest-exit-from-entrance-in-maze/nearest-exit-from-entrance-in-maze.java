// https://www.youtube.com/watch?v=Q4bqto_yG6I&ab_channel=codestorywithMIK
// classic bfs code - smallest or fastest bfs
class Solution {

    public static final int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; // rows
        int n = maze[0].length; // cols

        Queue<int[]> q = new LinkedList(); // q of coord

        // imp: when you add to the q, immediately mark as visited
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited

        int steps = 0;

        while (q.isEmpty() == false) {
            int N = q.size(); // level size

            for (int count = 0; count < N; count++) {
                int[] coord = q.poll();
                int i = coord[0];
                int j = coord[1];

                // if boundary reached, 
                // entrance is not exit
                if (entrance != coord && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    return steps;
                }

                // explore all neighbours
                for (int[] dir : directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    // if not out of bounds
                    // is not wall
                    if (new_i >= 0 && new_j >= 0 && new_i < m && new_j < n && maze[new_i][new_j] != '+') {
                        q.add(new int[] {new_i, new_j});
                        maze[new_i][new_j] = '+';
                    }
                }
            }
            steps++; // go to next level
        }

        return -1;
    }
}