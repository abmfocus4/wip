class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        int n = queries.size();
        double[] result = new double[n];
        int i = 0;

        for (List<String> query : queries) {
            String start = query.get(0);
            String end = query.get(1);
            result[i] = getPathWeight(start, end, new HashSet(), graph);
            i++;
        }

        return result;
    
    }

    private double getPathWeight(String start, String end, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
        if (graph.get(start) == null) {
            return -1.0;
        }

        if (graph.get(start).get(end) != null) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            String neighbourNode = neighbour.getKey();
            Double neighbourWeight = neighbour.getValue();
            if (visited.contains(neighbourNode) == false) {
                double neighbourToEndWeight = getPathWeight(neighbourNode, end, visited, graph);
                if (neighbourToEndWeight != -1.0) {
                    return neighbourWeight * neighbourToEndWeight;
                }
            }
        }

        return -1.0;
    }

    Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap();
        int i = 0;
        for (List<String> equation : equations) {
            String start = equation.get(0);
            String end = equation.get(1);

            if (graph.containsKey(start) == false) {
                graph.put(start, new HashMap());
            }
            graph.get(start).put(end, values[i]);
            
            if (graph.containsKey(end) == false) {
                graph.put(end, new HashMap());
            }
            graph.get(end).put(start, 1/values[i]);
            
            i++;
        }

        return graph;
    }
}