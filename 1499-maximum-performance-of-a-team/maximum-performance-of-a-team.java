class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // sum of speed * min of efficiency
        // min in window is chosen as efficiency
        int[][] team = new int[n][2];
        for (int i = 0; i < n; i++) {
            team[i] = new int[] {speed[i], efficiency[i]};
        }
        Arrays.sort(team, (a,b) -> b[1] - a[1]); // sort by efficiency big to small

        // slide window by popping min speed 
        PriorityQueue<Integer> q = new PriorityQueue<>(k+1);

        long maxPerf = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += team[i][0];
            q.add(team[i][0]);
            if (q.size() > k) {
                sum -= q.poll();
            }
            maxPerf = Math.max(maxPerf, sum * team[i][1]);
            
        }

        return (int) (maxPerf % (long)(1e9 + 7));
    }
}