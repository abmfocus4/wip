// Discussion: https://leetcode.com/problems/course-schedule/description/comments/1572589
// Topological sort: Multiple ways - DFS (stack based) / Kahn's algo BFS q based 
// Ref:https://www.youtube.com/watch?v=EUDwWbvtB_Q
// https://www.youtube.com/watch?v=3HHlOG05qEo
// https://www.youtube.com/watch?v=pcKY4hjDrxk


// Current sol is DFS but without using stack you are using the unvisited, visited, completed idea
// it's the arrival and departure style top sort algo
// https://leetcode.com/problems/course-schedule/solutions/1124408/clearly-explained-solution-1ms-java-dfs/comments/1218314
// Ref: https://leetcode.com/problems/course-schedule/solutions/1124408/clearly-explained-solution-1ms-java-dfs/?envType=list&envId=pxw54vnt
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjecency matrix of graph
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        // Fill all the nodes (0 to numCourses - 1) as array index holding newly created arraylists
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Fill the arraylists of each nodes with their outgoing edges/connected nodes
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's 
        int[] visited = new int[numCourses];

        // Do DFS for each of the array nodes to check a cycle
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, adj)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
        // Return true if the node is completed processing
        if (visited[node] == 2) {
            return true;
        }

        // Return false if the node is visited and viewed again before completion
        if (visited[node] == 1) {
            return false;
        }

        // Mark the node as visited
        visited[node] = 1;

        // DFS of all the other nodes current "node" is connected to
        for (int n : adj[node]) {
            if (!dfs(n, visited, adj)) {
                return false;
            }
        }

        // If no more other nodes for the current "node" mark as completed and return true
        visited[node] = 2;
        
        return true;
    }
}