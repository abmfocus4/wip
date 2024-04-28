// First do Meeting availableRooms I and Meeting availableRooms II - https://www.youtube.com/watch?v=uOTJITjfz9g&ab_channel=EricProgramming

// class Solution {
//     // return true if person can attend all meetings
//     // return false if cannot
//     public boolean canAttend(int[][] intervals) {
//         int N = intervals.length;
//         if (N == 0) return true;
//         Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
//         for (int i = 0; i < N-1; i++) {
//             int[] meeting1 = intervals[i];
//             int[] meeting2 = intervals[i+1];

//             if (meeting1[1] > meeting2[0]) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }


// class Solution {
//     public int minMeetingavailableRooms(int[][] intervals) {
//         // sort intervals by start time in ascending
//         Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

//         // minHeap to keep track of end times of meetings
//         PriorityQueue<Integer> minHeap = new PriorityQueue();
//         minHeap.add(intervals[0]);

//         // compare recently about to finish meeting with current meeting to see if meeting availableRooms can be reused
//         for (int i = 1; i < intervals.length; i++) {
//             if (minHeap.peek() <= intervals[i][0]) {
//                 minHeap.poll();
//             }
//             minHeap.add(intervals[i][1]);
//         }

//         // return currently running meeting availableRooms by the end
//         return minHeap.size();
//     }
// }

// https://leetcode.com/problems/meeting-availableRooms-iii/solutions/2527347/java-o-nlogn-heaps-and-sort-with-comments
 class Solution {
	public int mostBooked(int n, int[][] meetings) {
		// sort by start
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

		// available Rooms
		PriorityQueue<Integer> availableRooms = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++)
			availableRooms.add(i);

		// { meeting end, room taken } -> sort by end time and by room number
		PriorityQueue<int[]> usedRooms = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		// room usage count
		int[] count = new int[n];

		for (int[] meeting : meetings) {
            // if used meeting room can be reused (no overlap with current meeting case)
			while (usedRooms.isEmpty() == false && usedRooms.peek()[0] <= meeting[0]) 
				availableRooms.add(usedRooms.poll()[1]);
            
            int curMeetingStart = meeting[0];
            int curMeetingDuration = meeting[1] -  meeting[0];
            // if no meeting rooms available - then delay current meeting start time
			if (availableRooms.isEmpty()) {
				var await = usedRooms.poll(); // get latest meeting
				curMeetingStart = await[0]; // current meeting will start once that meeting ends
				availableRooms.add(await[1]); // add end time to 
			}

			// schedule the next meeting
			var room = availableRooms.poll();
			count[room]++;
			usedRooms.add(new int[] { curMeetingStart + curMeetingDuration, room});
		}

		// find the most used room
		int maxIdx = 0;
		for (int r = 0; r < count.length; r++)
			if (count[maxIdx] < count[r])
				maxIdx = r;

		return maxIdx;
	}
}