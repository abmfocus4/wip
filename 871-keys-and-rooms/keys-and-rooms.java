class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList();
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        int seen = 1;

        while(q.isEmpty() == false) {
            int room = q.poll();
            for (int nei : rooms.get(room)) {
                if (visited[nei]) continue;
                visited[nei] = true;
                q.add(nei);
                seen++;
            }
        }

        return seen == n;
    }
}