
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses]; 
        int course = 0;
        while (q.isEmpty() == false) {
            int node = (int) q.poll();
            order[course++] = node; // add to result
            visited++;
            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (numCourses == visited) {
            return order;
        } else {
            return new int[] {};
        }
    }
}