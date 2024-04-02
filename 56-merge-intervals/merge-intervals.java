class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        // add to list of merged intervals if no overlap
        List<int[]> mergedList = new ArrayList();
        // if overlap, max of last indices
        for (int[] interval : intervals) {
            if (mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]) {
                mergedList.add(interval);
            } else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}