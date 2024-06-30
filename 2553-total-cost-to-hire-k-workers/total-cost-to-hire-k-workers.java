// https://www.youtube.com/watch?v=IbhQ3U5NHLI&ab_channel=DeepCodes
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<int[]> cost_index = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        int i = 0;
        int j = costs.length - 1;
        long totalCost = 0;

        for (int x = 0; x < candidates; x++) {
            cost_index.offer(new int[] {costs[x], x});
            i++;
        }

        for (int x = Math.max(candidates, costs.length - candidates); x < costs.length; x++) {
            cost_index.offer(new int[] {costs[x], x});
            j--;
        }

        int hired = 0;

        while (hired < k) {
            int[] minCostIdx = cost_index.poll();
            totalCost += minCostIdx[0];
            System.out.println(minCostIdx[0]);
            hired++;

            if (i <= j) {
                if (minCostIdx[1] < i) {
                    cost_index.add(new int[] { costs[i], i });
                    i++;
                } else if (minCostIdx[1] > j) { // popped from right
                    cost_index.add(new int[] { costs[j], j });
                    j--;
                }
            }
            // popped from left side

        }

        return totalCost;
    }
}