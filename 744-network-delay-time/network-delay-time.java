class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();
        // key: src and value : list of edges
        // edge: key is v and value is w

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList());
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new Pair(v, w));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        // min heap sort by delay (int[0] = delay and int[1] = node)
        pq.add(new int[] {0, k});
        boolean[] visited = new boolean[n+1];

        int minDelay = 0;

        while (pq.isEmpty() == false) {
            int[] cur = pq.poll();
            int curDelay = cur[0], curNode = cur[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            minDelay = curDelay;
            n--;
            if (n == 0) return minDelay;
            for (Pair<Integer, Integer> neigh : graph.get(curNode)) {
                int neighNode = neigh.getKey(), neighDelay = neigh.getValue();
                pq.add(new int[] {curDelay + neighDelay, neighNode});
            }
        }

        if (n == 0) return minDelay;
        else return -1;

    }
}