class Solution {
    int minReorder;
    public int minReorder(int n, int[][] connections) {
        // create graph
        // assign neighbour if connections present
        // opp direction neighbour with negative sign

        // dfs
        // start from 0
        // visit all nodes

        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }
        for (int[] connection : connections) {
            int start = connection[0]; int end = connection[1];
            graph.get(start).add(end);
            graph.get(end).add(-start); // child points to parent
        }

        this.minReorder = 0;
        boolean[] visited = new boolean[n]; // 1 started processing, // 2 finished processing // -1 did not visit
        visited[0] = true; // mark as visited here
        dfs(0, visited, graph);
        return minReorder;
    }

    private void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
        int curNode = Math.abs(node);
        for (int neighbour : graph.get(curNode)) {
            int neighbourNode = Math.abs(neighbour);
            if (visited[neighbourNode] == true) {
                continue;
            }
            visited[neighbourNode] = true; // mark as visited here
            if (neighbour > 0) {
                System.out.println(neighbour);
                minReorder++;
            }
            dfs(neighbour, visited, graph);
        }
    }
}