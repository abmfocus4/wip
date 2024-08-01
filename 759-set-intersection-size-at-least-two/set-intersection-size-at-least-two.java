class Solution {    
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // Sort intervals: 1- end 2- start- O(nlogn)
        List<Integer> res = new ArrayList<>();

        // being greedy. more change of overlap with future intervals
        res.add(intervals[0][1] - 1); // Add one before end
        res.add(intervals[0][1]); // Add end

        for (int i = 1; i < n; i++) { // O(n)
            int start = intervals[i][0], end = intervals[i][1];
            int lastAdded = res.get(res.size() - 1), secondLastAdded = res.get(res.size() - 2);

            if (start > lastAdded) { // We need to add two fresh points, no overlap with previous interval
                res.add(end - 1);
                res.add(end);
            } else if (start == lastAdded) {
                res.add(end); // We already added one. We need to add the end of this interval
            } 
            
            else if (start > secondLastAdded) {
                res.add(end); // We already added lastAdded. We need one more
            }
        }
        return res.size();
    }
}