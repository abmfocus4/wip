class Solution {
    public int maxPoints(int[][] points) {
        // 2 points make a line
        // get dy and dx from that point
        // use the rest of the array to match the rwo points slope


        int n = points.length;
        if (n <= 1) return n;

        int maxPoints = 0;

        for (int i = 0; i < n; i++) { // x1
            for (int j = i+1; j < n; j++) { // x2
                int count = 2;

                int dx = points[j][0] - points[i][0]; // x2 - x1
                int dy = points[j][1] - points[i][1]; // y2 - y1

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int dx_ = points[k][0] - points[i][0]; // x3 - x1
                    int dy_ = points[k][1] - points[i][1]; // y3 - y1
                    if (dx * dy_ == dy * dx_) count++;
                }

                maxPoints = Math.max(maxPoints, count);
            }
        }

        return maxPoints;
         
    }
}