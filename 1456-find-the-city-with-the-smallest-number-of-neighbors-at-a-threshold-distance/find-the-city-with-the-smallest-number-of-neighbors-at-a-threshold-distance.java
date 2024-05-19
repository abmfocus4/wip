// https://www.youtube.com/watch?v=YbY8cVwWAvw&ab_channel=takeUforward
// floyd-warshall

// video ref: https://www.youtube.com/watch?v=PwMVNSJ5SLI&ab_channel=takeUforward
class Solution {
    int inf = Integer.MAX_VALUE; // or (int) 1e9
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPaths = new int[n][n];

        for (int[] row : shortestPaths) {
            Arrays.fill(row, inf); // inf init
        }

        // init possible distances
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0], to = edge[1], dist = edge[2];
            shortestPaths[from][to] = dist;
            shortestPaths[to][from] = dist;
        }

        // floyd warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        shortestPaths[i][j] = 0;
                        continue;
                    }

                    if (shortestPaths[i][k] == inf || shortestPaths[k][j] == inf) continue;

                    shortestPaths[i][j] = Math.min(shortestPaths[i][j], shortestPaths[i][k] + shortestPaths[k][j]);
                }
            }
        }

        // traverse 2d array - row by row
        // for each city, check how many cities under threshold
        // min cities update if city count < min cities
        // update city number
        int minCity = inf;
        int minCityCount = inf;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (shortestPaths[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCityCount) { // if equal pick greatest
                minCity = i;
                minCityCount = count;
            }
        }

        return minCity;

    }
}