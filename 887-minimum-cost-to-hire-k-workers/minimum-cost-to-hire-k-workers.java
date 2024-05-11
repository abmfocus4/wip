// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solutions/141768/detailed-explanation-o-nlogn
// https://www.youtube.com/watch?v=f879mUH6vJk&ab_channel=NeetCodeIO
class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
            // sort in ascending
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // 0 is ration and // 1 is quality
        double minCost = Double.MAX_VALUE, qualitySum = 0;
        // use max heap - eject max quality - reduce our max cost
        Queue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b,a));
        for (double[] worker: workers) {
            qualitySum += worker[1];
            pq.add(worker[1]);
            if (pq.size() > K) qualitySum -= pq.poll();
            if (pq.size() == K) minCost = Math.min(minCost, qualitySum * worker[0]);
        }
        return minCost;
    }
}