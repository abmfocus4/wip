class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Map<Integer, Integer>> adj_list = new HashMap();

        for (int[] time : times) {
            if (adj_list.containsKey(time[0]) == false) {
                adj_list.put(time[0], new HashMap());
            }
            adj_list.get(time[0]).put(time[1], time[2]);
        }

        // time, dst node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // add src
        pq.add(new int[] {0, k});

        boolean[] visited = new boolean[n+1]; // total nodes
        int minDist = 0;

        while (pq.isEmpty() == false) {
            int[] cur = pq.poll();
            int curNode = cur[1], curDist = cur[0];
            if (visited[curNode]) continue;

            visited[curNode] = true;
            minDist = curDist;
            n--;
            if (n == 0) return minDist;

            if (adj_list.containsKey(curNode)) {
                for (var neighbor : adj_list.get(curNode).keySet()) {
                    pq.add(new int[] {curDist + adj_list.get(curNode).get(neighbor), neighbor});
                }
            }

        }

        return n == 0 ? minDist : -1; // are you able to reach all nodes or not
    }
}