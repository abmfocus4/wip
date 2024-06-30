class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create graph
        // int: src as key; Pair of dst and price as value

        // int[] stops - won't continue algo for more stops

        // pq with priority as price

        // steps = stops + 1

        // add neighbour edges to pq

        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.get(from).add(new Pair(to, price));
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // int[0] = price, int[1] = node, int[2] = steps
        pq.add(new int[] {0, src, 0});
        // stops[src] = 0;

        while (pq.isEmpty() == false) {
            int[] cur = pq.poll();
            int curPrice = cur[0], curNode = cur[1], curSteps = cur[2];
            if (stops[curNode] < curSteps || curSteps > k + 1) continue;
            if (curNode == dst) return curPrice;
            stops[curNode] = curSteps;
            for (Pair<Integer, Integer> neigh : graph.get(curNode)) {
                int neighNode = neigh.getKey(), neighPrice = neigh.getValue();
                pq.add(new int[] {curPrice + neighPrice, neighNode, curSteps + 1});
            }
        }

        return -1;

    }
}