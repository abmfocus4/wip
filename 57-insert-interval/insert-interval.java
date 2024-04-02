class Solution {
    // Time: O(n)
    // Space: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // prepare result
        List<int[]> inserted = new ArrayList<>();
        // traverse intervals
        for (int[] interval:intervals) {
            // new interval left no overlap of current interval (will never intersect with any interval rest of list)
            // here onwards only if condition will occur
            if (newInterval[1] < interval[0]) {
                inserted.add(newInterval);
                newInterval = interval;
            } else if (newInterval[0] > interval[1]) {
                // new interval right no overlap, current interval will remain unchanged, future intervals might change
                inserted.add(interval);
            } else {
                // if overlap, update interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
    
        inserted.add(newInterval);
        return inserted.toArray(new int[inserted.size()][]);
    }
}