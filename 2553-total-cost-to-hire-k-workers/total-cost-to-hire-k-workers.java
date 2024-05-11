// https://www.youtube.com/watch?v=ODuICq8exLo&ab_channel=codestorywithMIK
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> pq_left = new PriorityQueue<>();
        PriorityQueue<Integer> pq_right = new PriorityQueue<>();

        long totalCost = 0;
        int hired = 0;
        while (hired < k) {
            while (pq_left.size() < candidates && i <= j) {
                pq_left.offer(costs[i++]);
            }
            while (pq_right.size() < candidates && i <= j) {
                pq_right.offer(costs[j--]);
            }

            int t1 = pq_left.size() > 0 ? pq_left.peek() : Integer.MAX_VALUE;
            int t2 = pq_right.size() > 0 ? pq_right.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                totalCost += t1;
                pq_left.poll();
            } else {
                totalCost += t2;
                pq_right.poll();
            }
            hired++;
        }
        return totalCost;
    }
}