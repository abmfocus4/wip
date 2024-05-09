class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // same as this problem (with small diff of atmost k elements)- https://leetcode.com/problems/maximum-subsequence-score/submissions/1253164216/?envType=study-plan-v2&envId=leetcode-75
        
        // create pairs of corresponding speed and efficiency indexes
        // sort pairs by efficiency in descending order
        // create min heap to keep track of k elements used to calculate performance
        
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {speed[i], efficiency[i]};
        }

        Arrays.sort(pairs, (a,b)->b[1] - a[1]);

        Queue<Integer> minHeap = new PriorityQueue(k+1);

        long maxPerf = 0;
        long curPerf = 0;
        for (int[] pair : pairs) {
            minHeap.add(pair[0]);
            curPerf += pair[0];
            if (minHeap.size() > k) curPerf -= minHeap.poll();
            maxPerf = Math.max(maxPerf, curPerf * pair[1]); // DIFF FROM OTHER PROBLEM (NO K CHECK)
        }

        return (int) (maxPerf % (long)(1e9 + 7));

    }
}