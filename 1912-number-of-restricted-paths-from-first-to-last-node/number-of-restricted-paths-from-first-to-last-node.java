class Solution {
    int mod = 1_000_000_007;
    public int countRestrictedPaths(int n, int[][] edges) {
        // graph generate
        // dijkstra to get dist[n] distance to n from each node
        // dfs to find all restricted paths

        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x -> new ArrayList()).add(new Pair<>(v, w));
            graph.computeIfAbsent(v, x -> new ArrayList()).add(new Pair<>(u, w));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        // node, w
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        pq.add(new Pair(n, 0));


        while (pq.isEmpty() == false) {
            Pair<Integer, Integer> cur = pq.poll();
            int curNode = cur.getKey();
            int curW = cur.getValue();

            if (graph.get(curNode) == null) continue;
            for (Pair<Integer, Integer> nei : graph.get(curNode)) {
                int neiNode = nei.getKey();
                int neiW = nei.getValue();
                if (dist[neiNode] > curW + neiW) {
                    dist[neiNode] = curW + neiW;
                    pq.add(new Pair(neiNode, dist[neiNode]));
                }
            }
        }

        Integer[] dp = new Integer[n+1]; // number of restricted paths from node to n
        return dfs(1, n, dist, dp, graph);
    }

    private int dfs(int startNode, int endNode, int[] dist, Integer[] dp, Map<Integer, List<Pair<Integer, Integer>>> graph) {
        if (startNode == endNode) {
            return 1;
        }
        if (dp[startNode] != null) {
            return dp[startNode];
        }
        long paths = 0;
        for (Pair<Integer, Integer> nei : graph.get(startNode)) {
            if (dist[startNode] > dist[nei.getKey()]) {
                paths += dfs(nei.getKey(), endNode, dist, dp, graph);
            }
        }

        paths %= mod;
        return dp[startNode] = (int) paths;
    }
}