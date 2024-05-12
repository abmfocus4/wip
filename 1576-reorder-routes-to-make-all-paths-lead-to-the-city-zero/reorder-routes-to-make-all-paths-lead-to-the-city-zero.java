// https://www.youtube.com/watch?v=m17yOR5_PpI&ab_channel=NeetCode
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj_list = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList());
        }

        for (int i = 0; i < connections.length; i++) {
            adj_list.get(connections[i][0]).add(connections[i][1]); // given
            adj_list.get(connections[i][1]).add(-connections[i][0]); // opp dir
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList();
        q.add(0);
        visited[0] = true;

        int numReorder = 0;

        while(q.isEmpty() == false) {
            int cur = q.poll();
            for (int neighbour : adj_list.get(Math.abs(cur))) {
                if (visited[Math.abs(neighbour)] == false) {
                    q.add(neighbour);
                    visited[Math.abs(neighbour)] = true;
                    if (neighbour > 0) {
                        numReorder++; // road out of cur to neighbour
                    }
                }
            }
        }

        return numReorder;
    }
}