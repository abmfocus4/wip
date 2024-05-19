// djikstra's with 2d array
// https://www.youtube.com/watch?v=0ytpZyiZFhA&ab_channel=takeUforward
class Solution {
    int INF = (int) 1e9;

    class PQElement {
        int diff;
        int src;
        int dst;

        public PQElement(int diff, int src, int dst) {
            this.diff = diff;
            this.src = src;
            this.dst = dst;
        }
    }

    int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minEffort = new int[m][n]; // fully connected (use int[])

        for (int[] row : minEffort) {
            Arrays.fill(row, INF);
        }

        PriorityQueue<PQElement> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new PQElement(0, 0, 0)); // start at (0,0)
        minEffort[0][0] = 0;
        int newEffort = INF;

        while (pq.isEmpty() == false) {
            PQElement cur = pq.poll();
            if (cur.src == m - 1 && cur.dst == n - 1) {
                return cur.diff;
            }

            for (int[] dir : dirs) {
                int newSrc = cur.src + dir[0];
                int newDst = cur.dst + dir[1];
                if (newSrc < 0 || newSrc >= m || newDst < 0 || newDst >= n) continue;
                newEffort = Math.max(Math.abs(heights[newSrc][newDst] - heights[cur.src][cur.dst]), cur.diff);
                if (newEffort < minEffort[newSrc][newDst]) {
                    minEffort[newSrc][newDst] = newEffort;
                    pq.add(new PQElement(newEffort, newSrc, newDst));
                }

            }
        }

        return -1;

    }
}