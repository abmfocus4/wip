class Solution {
    // bellmann ford
    // calculate how much time it takes to get to last node (max time)
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delays = new int[n+1];
        Arrays.fill(delays, Integer.MAX_VALUE);
        delays[k] = 0;

        int[] tmp = Arrays.copyOf(delays, n+1); // n+1 since node 0 is not considered

        for (int i = 0; i < n; i++) {
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                if (delays[u] == Integer.MAX_VALUE) continue;
                if (delays[u] + w < tmp[v]) {
                    tmp[v] = delays[u] + w;
                }
            }
            delays = Arrays.copyOf(tmp, n+1);
        }

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            res = Math.max(res, delays[i]); // starting from node 1 to N
        }

        return res == Integer.MAX_VALUE ? -1 : res; // if any node is MAX then it was unreachable

    }
}