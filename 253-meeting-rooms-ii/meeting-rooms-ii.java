class Solution {
    // use min heap
    // sort by start time
    // return size of pq
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int[] interval : intervals) {
            if (pq.isEmpty() == false && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}