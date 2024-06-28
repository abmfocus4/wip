class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack();
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        stack.add(0);
        visited[0] = true;

        int seen = 0;

        while (stack.isEmpty() == false) {
            int room = stack.pop();
            seen++;
            for (int neighbour : rooms.get(room)) {
                if (visited[neighbour] == true) continue;
                stack.add(neighbour);
                visited[neighbour] = true;
            }
            
        }

        return seen == n;
    }
}