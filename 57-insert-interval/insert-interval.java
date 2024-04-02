class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> insertedList = new ArrayList();
        
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                insertedList.add(newInterval);
                newInterval = interval;
            } else if (newInterval[0] > interval[1]) {
                insertedList.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        insertedList.add(newInterval);
        return insertedList.toArray(new int[insertedList.size()][]);
    }
}