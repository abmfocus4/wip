class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // create graph: Map<Integer, List<Integer>
        // indegree populate
        // add to q
        // iterate over q
        // find max time it takes to complete any one course

        Map<Integer, List<Integer>> graph = new HashMap();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }

        int[] indegree = new int[n];

        for (int[] relation : relations) {
            int start = relation[0] - 1;
            int end = relation[1] - 1;
            graph.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> q = new LinkedList();
        int[] minTime = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                minTime[i] = time[i];
            }
        }

        while (q.isEmpty() == false) {
            int curNode = q.poll();
            for (int nei : graph.get(curNode)) {
                minTime[nei] = Math.max(minTime[nei], minTime[curNode] + time[nei]);
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        int finalTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            finalTime = Math.max(finalTime, minTime[i]);
        }

        return finalTime;
    }
}