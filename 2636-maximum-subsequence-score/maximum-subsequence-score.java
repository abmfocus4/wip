// code ref: https://leetcode.com/problems/maximum-subsequence-score/solutions/3092528/easiest-to-understand
// explanation : https://www.youtube.com/watch?v=ax1DKi5lJwk&ab_channel=NeetCodeIO
class Solution {
    public long maxScore(int[] a, int[] b, int k) {
        int n = a.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) pairs[i] = new int[] {a[i], b[i]};
        Arrays.sort(pairs, (x, y) -> y[1] - x[1]); // getting max min value
        Queue<Integer> q = new PriorityQueue<>(k+1); // min heap
        long res = 0, sum = 0;
        for (int[] p : pairs) {
            q.add(p[0]); // corresponding value in a for max min in b
            sum += p[0];
            if (q.size() > k) sum -= q.poll();
            if (q.size() == k) res = Math.max(res, sum * p[1]);
        }
        return res;
    }
}