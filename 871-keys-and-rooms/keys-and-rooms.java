class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack();
        dfs.add(0);
        HashSet<Integer> visited = new HashSet();
        visited.add(0);
        while (dfs.isEmpty() == false) {
            int room = dfs.pop();
            // get all keys from room
            for (int key : rooms.get(room)) {
                if (visited.contains(key) == false) {
                    dfs.add(key);
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