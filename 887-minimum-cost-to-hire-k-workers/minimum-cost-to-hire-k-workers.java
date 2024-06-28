class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // first find rate
        // store rate and quality in pairs
        // sort workers based on rate (take min rate first)
        // store window in max heap
        // before adding new element, pop max quality from heap and add new worker

        int n = quality.length;

        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new double[] {(double)wage[i]/quality[i], (double)quality[i]};
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a[0],b[0]));

        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b,a));

        double minCost = Double.MAX_VALUE;

        double sumQuality = 0;

        for (double[] worker : workers) {
            sumQuality += worker[1];
            pq.add(worker[1]);
            if (pq.size() > k) {
                sumQuality -= pq.poll();
            }
            if (pq.size() == k) {
                minCost = Math.min(minCost, sumQuality*worker[0]);
            }
        }

        return minCost;
    
    }
}