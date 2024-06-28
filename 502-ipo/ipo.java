class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // min heap - capital, profilts pair
        // max heap - profits

        PriorityQueue<int[]> capitalHeap = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> profitsHeap = new PriorityQueue<Integer>((a,b) -> b-a);

        int n = profits.length;

        for (int i = 0; i < n; i++) {
            capitalHeap.add(new int[] {capital[i], profits[i]});
        }

        while (k-- > 0) {

            while (capitalHeap.isEmpty() == false && capitalHeap.peek()[0] <= w) {
                profitsHeap.add(capitalHeap.poll()[1]);
            }

            if (profitsHeap.isEmpty()) break;
            w += profitsHeap.poll();
        }

        return w;
    }
}