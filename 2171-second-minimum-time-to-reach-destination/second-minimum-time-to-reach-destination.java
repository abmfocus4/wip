class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1], freq = new int[n + 1];
        // dist1[i] stores the minimum time taken to reach node i from node 1. dist2[i]
        // stores the second minimum time taken to reach node from node 1. freq[i]
        // stores
        // the number of times a node is popped out of the heap.

        // Initialize a frequency array freq to store the number of times when a node is
        // popped out of the queue. Since we need the second minimal distance, each node
        // can be poped out at most twice.
        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = Integer.MAX_VALUE;
            freq[i] = 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] { 1, 0 }); // {node_id, distance}
        dist1[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0], timeTaken = cur[1];

            freq[curNode]++;
            if (freq[curNode] == 2 && curNode == n) {
                return timeTaken;
            }

            // red light
            if (timeTaken/change % 2 == 1) {
                timeTaken = change * (timeTaken/change + 1) + time;
            } else {
                timeTaken = timeTaken + time;
            }

            if (adj.get(curNode) == null) continue;

            for (int neiNode : adj.get(curNode)) {
                if (freq[neiNode] == 2) continue;
            
                if (dist1[neiNode] > timeTaken) {
                    dist2[neiNode] = dist1[neiNode];
                    dist1[neiNode] = timeTaken;
                    pq.add(new int[] {neiNode, dist1[neiNode]});
                } else if (dist2[neiNode] > timeTaken && dist1[neiNode] != timeTaken) {
                    dist2[neiNode] = timeTaken;
                    pq.add(new int[] {neiNode, timeTaken});
                }
            }
        }
        return 0;
    }
}