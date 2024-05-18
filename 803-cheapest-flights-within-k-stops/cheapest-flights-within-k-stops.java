class Solution {
    // bellman ford bfs
    // https://www.youtube.com/watch?v=5eIK3zUdYmE&ab_channel=NeetCode
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k+1; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) { //src, dst, price
                int flight_src = flight[0], flight_dst = flight[1], flight_price = flight[2];
                if (prices[flight_src] == Integer.MAX_VALUE) continue;
                if (prices[flight_src] + flight_price < tmpPrices[flight_dst]) {
                    tmpPrices[flight_dst] = prices[flight_src] + flight_price;
                }
            }

            prices = Arrays.copyOf(tmpPrices, n); // copy tmp prices to prices
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}