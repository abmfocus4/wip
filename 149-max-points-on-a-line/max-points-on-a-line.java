class Solution {
    public int maxPoints(int[][] points) {
        // hashmap to store slope str <int, int> <dy, dx> = key, value = freq
        // dy/dx is unique (so find gcd of dy, dx and divide)
        // keep track of maxPoints with point[i] as reference for all other points
        // clear map for every key value pair

        int n = points.length;
        HashMap<String, Integer> map = new HashMap(); // slope, freq
        int localMaxPoints = 0;
        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i+1; j < n; j++) { // start from next point
                int[] point1 = points[i];
                int[] point2 = points[j];

                int dy = point2[1] - point1[1]; // y2 - y1
                int dx = point2[0] - point1[0]; // x2 - x1

                int gcd = gcd(dy, dx);

                dy = dy/gcd;
                dx = dx/gcd;

                String slope = dy + "-" + dx;
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMaxPoints = Math.max(map.get(slope), localMaxPoints);
            }

            maxPoints = Math.max(maxPoints, localMaxPoints + 1); // account for point[i];
        }

        return maxPoints;
    }

    private int gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b); // err
    }

}