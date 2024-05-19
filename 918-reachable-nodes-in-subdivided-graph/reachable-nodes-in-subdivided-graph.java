class Node implements Comparable<Node> {
    int u;
    int w;
    Node (int u, int w) {
        this.u = u;
        this.w = w;
    }
    @Override 
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // 0 ... n-1 nodes 
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int[] dis=new int[n];
        List<List<Node>> adj=new ArrayList<>();
        for (int i=0;i<n;i++) {
            dis[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        dis[0] = 0;
        for (int[] edge: edges) {
            adj.get(edge[0]).add( new Node(edge[1], edge[2]+1) );
            adj.get(edge[1]).add( new Node(edge[0], edge[2]+1) );
        }
        pq.add( new Node(0, 0) );
        while (!pq.isEmpty()) {
            Node node=pq.poll();
            int src=node.u;
            for (Node nei: adj.get(src)) {
                if (dis[src] + nei.w < dis[nei.u] ) {
                    dis[nei.u] = dis[src] + nei.w;
                    pq.add(new Node(nei.u, dis[nei.u])  );
                }

            }
        }
        int ans = 0;
        for (int i=0;i<edges.length;i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            int t1=Math.min(  Math.max(maxMoves-dis[u], 0),   w   );
            int t2=Math.min(  Math.max(maxMoves-dis[v], 0),   w    );
            ans += Math.min(w,t1+t2);
        }
        for (int i=0;i<n;i++) {
            if (dis[i]<=maxMoves) ans++;
        }
        return ans;
    }
}