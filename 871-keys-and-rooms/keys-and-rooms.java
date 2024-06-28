class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Stack<Integer> stack = new Stack();
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        stack.add(0);
        visited[0] = true;

        int seen = 1;

        while (stack.isEmpty() == false) {
            int room = stack.pop();
            for (int nei : rooms.get(room)) {
                if (visited[nei]) continue;
                visited[nei] = true;
                stack.add(nei);
                seen++;
            }
        }

        return n == seen;
    }
}