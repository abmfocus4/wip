class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> bfs = new LinkedList();
        bfs.add(0);
        HashSet<Integer> visited = new HashSet();
        visited.add(0);
        while (bfs.isEmpty() == false) {
            int room = bfs.poll();
            // get all keys from room
            for (int key : rooms.get(room)) {
                if (visited.contains(key) == false) {
                    bfs.add(key);
                    visited.add(key);
                    if (rooms.size() == visited.size()) {
                        return true;
                    }
                }

            }
        }
        return rooms.size() == visited.size();
    }
}