class Solution {
    public int minReorder(int n, int[][] connections) {
        int reorder = 0;
        // graph - int to list of int
        Map<Integer, List<Integer>> adj_list = new HashMap();

        for (int i = 0; i < n; i++) {
            if (adj_list.containsKey(i) == false) {
                adj_list.put(i, new ArrayList());
            }
        }

        for (int[] connection : connections) {
            adj_list.get(connection[0]).add(connection[1]); // current direction
            adj_list.get(connection[1]).add(-connection[0]); // opp direction 
        }

        Queue<Integer> q = new LinkedList();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        while (q.isEmpty() == false) {
            int node = q.poll();
            // go to all neighbours of node
            // if not visited, add to q
            // check if it is pos: add to reorder
            List<Integer> neighs = adj_list.get((node));
            if (neighs == null || neighs.size() == 0) continue;
            for (int neigh : neighs) {
                if (visited[Math.abs(neigh)] == false) {
                    visited[Math.abs(neigh)] = true;
                    q.add(Math.abs(neigh));
                    if (neigh > 0) {
                        reorder++;
                    }
                } 
            }
        }
        return reorder;
    }
}