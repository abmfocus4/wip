class Solution {
    class PQElement {
        int price;
        int dst;
        int steps;

        PQElement(int price, int dst, int steps) {
            this.price = price;
            this.dst = dst;
            this.steps = steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dijkstra
        // keep track of stops in [] for each node from src
        // pq to greedily search for lowest price edges
        // keep track of steps in edges
        // dst node as well

        // create graph
        Map<Integer, List<int[]>> graph = new HashMap();

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            graph.computeIfAbsent(u, x -> new ArrayList()).add(new int[] {v, price});
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        // price, dst, steps
        PriorityQueue<PQElement> pq = new PriorityQueue<>((a,b) -> a.price - b.price);
        pq.add(new PQElement(0, src, 0));

        while (pq.isEmpty() == false) {
            PQElement cur = pq.poll();
            int curPrice = cur.price, curNode = cur.dst, curSteps = cur.steps;
            if (stops[curNode] < curSteps || curSteps > k + 1) continue;
            stops[curNode] = curSteps;
            if (curNode == dst) return curPrice;
            if (graph.containsKey(curNode) == false) continue;
            for (int[] nei : graph.get(curNode)) {
                int neiNode = nei[0];
                int curNodeToNeiPrice = nei[1];
                pq.add(new PQElement(curNodeToNeiPrice + curPrice, neiNode, curSteps + 1));
            }
        }

        return -1;
    }
}