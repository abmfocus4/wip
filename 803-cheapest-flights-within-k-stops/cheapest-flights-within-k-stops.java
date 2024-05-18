// https://www.youtube.com/watch?v=HBfvhLlO_po&ab_channel=AryanMittal
// Modified Dijkstra's
class Solution {
    class Edge {
        int dst;
        int price;

        public Edge(int dst, int price) {
            this.dst = dst;
            this.price = price;
        }
    }

    class PQElement {
        int price;
        int dst;
        int steps;

        public PQElement (int price, int dst, int steps) {
            this.price = price;
            this.dst = dst;
            this.steps = steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create adj list
        ArrayList<ArrayList<Edge>> adj_list = new ArrayList();

        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList());
        }

        for (int[] flight : flights) {
            int flight_src = flight[0], flight_dst = flight[1], flight_price = flight[2];
            adj_list.get(flight_src).add(new Edge(flight_dst, flight_price));
        }

        int[] stops = new int[n]; // steps taken to reach stop from src
        Arrays.fill(stops, Integer.MAX_VALUE);

        // {price, dst node, steps}
        PriorityQueue<PQElement> pq = new PriorityQueue<>((a,b) -> a.price - b.price);
        pq.add(new PQElement(0, src, 0));

        while (pq.isEmpty() == false) {
            PQElement cur = pq.poll();
            // steps = stop + 1
            if (cur.steps > stops[cur.dst] || cur.steps > k+1) continue;
            stops[cur.dst] = cur.steps;
            if (cur.dst == dst) return cur.price;
            for (Edge neighbor : adj_list.get(cur.dst)) {
                pq.add(new PQElement(cur.price + neighbor.price, neighbor.dst, cur.steps + 1));
            }
        }

        return -1;

    }
}