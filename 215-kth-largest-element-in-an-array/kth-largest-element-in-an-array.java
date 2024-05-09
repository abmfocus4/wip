class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            max_heap.add(i);
        }

        for (int i = 0; i < k - 1; i++) {
            max_heap.poll();
        }

        return max_heap.peek();
    }
}