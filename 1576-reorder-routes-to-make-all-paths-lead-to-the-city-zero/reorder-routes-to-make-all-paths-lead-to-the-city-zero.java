class Solution {
    public int minReorder(int n, int[][] connections) {
        // create graph
        // assign neighbour if connections present
        // opp direction neighbour with negative sign

        // bfs
        // use q and visited to traverse the tree

        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }
        for (int[] connection : connections) {
            int start = connection[0]; int end = connection[1];
            graph.get(start).add(end);
            graph.get(end).add(-start); // child points to parent
        }

        Queue<Integer> q = new LinkedList();
        q.add(0);

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[0] = true;


        int minReorder = 0;
        while (q.isEmpty() == false) {
            int curNode = q.poll();
            for (int neighbour : graph.get(curNode)) {
                int neighbourNode = Math.abs(neighbour);
                if (visited[neighbourNode] == true) {
                    continue;
                }
                visited[neighbourNode] = true;
                q.add(neighbourNode);
                if (neighbour > 0) {
                    minReorder++;
                } 
            }
        }

        return minReorder;
    }
}