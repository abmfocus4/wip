// top sort - kahns algo
// create adjacency list (graph)
// indegree array
// 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj_list = new ArrayList();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj_list.add(new ArrayList());
        }

// 1,0
// 1<-0
        for (int[] prereq : prerequisites) {
            adj_list.get(prereq[0]).add(prereq[1]);
            indegree[prereq[1]]++;
        }

        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int visited = 0;

        while (q.isEmpty() == false) {
            int curCourse = q.poll();
            List<Integer> courseList = adj_list.get(curCourse);
            for (int course : courseList) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.add(course);
                }
            }
            visited++;
        }

        return visited == numCourses;


    }
}