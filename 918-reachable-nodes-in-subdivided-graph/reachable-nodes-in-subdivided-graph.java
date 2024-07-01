class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // create graph

        // use dist to keep track of min distance so far

        // ans to keep track of nodes visited

        // used to keep track of how of an edge is used encoding u * n + v is used
        // used maps unique edge to how much it was used

        // you can use pair of u v instead or [long edgeKey = ((long) u << 32) | v]

        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        // store dist, node so far
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});

        Map<Integer, Integer> dist = new HashMap();
        dist.put(0, 0);

        Map<Integer, Integer> used = new HashMap();

        int ans = 0;

        while(pq.isEmpty() == false) {
            int[] cur = pq.poll();
            int curDist = cur[0], curNode = cur[1];
            if (curDist > dist.getOrDefault(curNode, 0)) continue;
            ans++;
            for (Pair<Integer, Integer> neigh : graph.get(curNode)) {
                int neighNode = neigh.getKey(), neighDist = neigh.getValue();
                // edge used
                used.put(curNode * n + neighNode, Math.min(neighDist, maxMoves - curDist));
                if (curDist + neighDist + 1 < dist.getOrDefault(neighNode, maxMoves + 1)) {
                    dist.put(neighNode, curDist + neighDist + 1);
                    pq.add(new int[] {curDist + neighDist + 1, neighNode});
                }
            }
        }

        for (int[] edge : edges) {
            // min of weight
            // edge used from one side and edge used from other side
            ans += Math.min(edge[2], used.getOrDefault(edge[0] * n + edge[1], 0) + 
                                        used.getOrDefault(edge[1] * n + edge[0], 0));
        }

        return ans;
    }
}