class Solution {
    // use arrays instead of lists in interview - https://leetcode.com/problems/evaluate-division/solutions/171649/1ms-dfs-with-explanations
    // explanation: https://www.youtube.com/watch?v=Uei1fwDoyKk&ab_channel=NeetCodeIO
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
        // start node -> (end node, start node/ end node value)

        // for each query in queries, find result value

        // find result value

        // query start node has to exist - neg case
        // query start and end are neighbors - pos case

        // gen case: dfs from query start to find query end node
        // multiply weights along the way
        // return multiplied weights

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            res[i] = getPathWeight(start, end, new HashSet(), graph);
        }
        return res;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap();
        int i = 0;
        for (List<String> equation : equations) {
            String start = equation.get(0);
            String end = equation.get(1);

            // pos edge
            if (graph.containsKey(start) == false) {
                graph.put(start, new HashMap());
            }
            graph.get(start).put(end, values[i]); // get map and put into it
            
            // neg edge : inverse of value
            if (graph.containsKey(end) == false) {
                graph.put(end, new HashMap());
            }
            graph.get(end).put(start, 1/values[i]);

            i++; // increment to next equation
        }

        return graph;
    }

    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {

        if (graph.containsKey(start) == false) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        // visit each neighbor
        // set view of hash map using entrySet()
        for (var neighbor : graph.get(start).entrySet()) {
            if (visited.contains(neighbor.getKey()) == false) { // if not visited
                // get weight from neighbor to end
                double neighborWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
                // product of start to neighbour and neighbour to end
                if (neighborWeight != -1.0) {
                    return neighbor.getValue() * neighborWeight;
                }
            }
        }

        return -1.0;
    }
}