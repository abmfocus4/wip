class Solution {
    public int findCircleNum(int[][] isConnected) {
        // if i,j == 1 then isConnected. if you find a node that is not visited (is not previously connected) the run bfs using that node as starting point
        // at the end all the nodes should be visited
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                provinces++;
                bfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList();
        q.add(node);
        while (q.isEmpty() == false) {
            int curNode = q.poll();
            // visit all neighbours and add them to q for traversal
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[curNode][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}