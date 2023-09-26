class Solution {
    // Sorting solution
    // Time: Sort + Traversal
    // Time: O(log(n)) + O(n) = O(nlogn)
    // Space: O(logN) or log(N)
    public int[][] merge(int[][] intervals) {
        // arrange intervals start index from small to big (early to late)
        // Time: log(n)
        // Space: Sorting takes O(n) or constant based on sorter
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // result preparation
        LinkedList<int[]> merged = new LinkedList<>();
        // Time: O(n)
        for (int[] interval:intervals) {
            // base case: if first interval of list or intervals don't overlap
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // if intervals overlap, update last index of previous interval already in list with index of max interval
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        // size of result is size of merged list (each interval is size 2)
        return merged.toArray(new int[merged.size()][]);
    }
}