class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for (int[] edge: relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            indegree[y]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] minTime = new int[n];
        
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
                minTime[node] = time[node];
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor: graph.get(node)) {
                minTime[neighbor] = Math.max(minTime[neighbor], minTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, minTime[node]);
        }

        return ans;
    }
    
}