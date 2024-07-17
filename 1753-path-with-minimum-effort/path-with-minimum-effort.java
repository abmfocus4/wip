class Solution {
    class PQElement {
        int row;
        int col;
        int diff;

        PQElement() {};
        PQElement(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }

    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minEffort = new int[m][n];
        for (int[] row : minEffort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;

        PriorityQueue<PQElement> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new PQElement(0, 0, 0));

        while (pq.isEmpty() == false) {
            PQElement cur = pq.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curDiff = cur.diff;

            if (curRow == m - 1 && curCol == n - 1) {
                return curDiff;
            }

            for (int[] dir : dirs) {
                int newRow = curRow + dir[0], newCol = curCol + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
                int newEffort = Math.max(Math.abs(heights[newRow][newCol] - heights[curRow][curCol]), curDiff);
                if (minEffort[newRow][newCol] > newEffort) {
                    minEffort[newRow][newCol] = newEffort;
                    pq.add(new PQElement(newRow, newCol, minEffort[newRow][newCol]));
                }
            }
        }

        return -1;
    }
}