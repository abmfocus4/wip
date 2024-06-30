class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // room count - int[]
        // usedMeeting rooms - min heap - end time, room idx
        // available rooms - min heap - room idx

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        int[] roomCount = new int[n];

        PriorityQueue<Integer> availableRooms = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        PriorityQueue<int[]> usedRooms = new PriorityQueue<int[]>((a,b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

        for (int[] meeting : meetings) {
            // check if any rooms can be reused
            while (usedRooms.isEmpty() == false && usedRooms.peek()[0] <= meeting[0]) {
                availableRooms.add(usedRooms.poll()[1]);
            }
            // postpone if no available rooms
            int meetingStartTime = meeting[0];
            int meetingDuration = meeting[1] - meeting[0];
            if (availableRooms.isEmpty()) {
                int[] lastMeeting = usedRooms.poll();
                meetingStartTime = lastMeeting[0];
                availableRooms.add(lastMeeting[1]);
            }
            // use available rooms
            int room = availableRooms.poll();
            roomCount[room]++;
            usedRooms.add(new int[] {meetingStartTime + meetingDuration, room});
        }

        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[maxIdx] < roomCount[i]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}