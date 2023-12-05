// Ref: https://www.youtube.com/watch?v=2NN6N-tNyag
// Time: O(nlogn)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // ascending order O(nlogn)
        int[] prev = intervals[0];
        int counter = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] > intervals[i][0]) {
                // overlapping intervals found
                counter++;
                if (prev[1] > intervals[i][1]) { // remove interval with larger end time
                    prev = intervals[i];
                }
            } else {
                prev = intervals[i];
            }
        }
        return counter;
    }
}