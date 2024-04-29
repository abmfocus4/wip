// Discussion: https://leetcode.com/problems/course-schedule/description/comments/1572589
// Topological sort: Multiple ways - DFS (stack based) / Kahn's algo BFS q based 
// Ref BFS mod Kahn's algo:https://www.youtube.com/watch?v=EUDwWbvtB_Q
// Top Sort: https://www.youtube.com/watch?v=3HHlOG05qEo
// Graph Traversals: https://www.youtube.com/watch?v=pcKY4hjDrxk


// BFS TOP SORT IMPL:
// Ref BFS mod Kahn's algo:https://www.youtube.com/watch?v=EUDwWbvtB_Q
// Code ref: https://leetcode.com/problems/course-schedule/solutions/58524/java-dfs-and-bfs-solution/?envType=list&envId=pxw54vnt

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        int visited = 0;

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList();
        }

        for (int[] prereq : prerequisites) {
            adj[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.isEmpty() == false) {
            int node = (int)q.poll();
            visited++;
            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        } 
        return numCourses == visited;
    }
}