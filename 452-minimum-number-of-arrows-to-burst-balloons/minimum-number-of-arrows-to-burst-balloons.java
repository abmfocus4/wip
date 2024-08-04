class Solution {
    // https://www.youtube.com/watch?v=c_5n_qdDRDo&ab_channel=EricProgramming
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1) return n;

        Arrays.sort(points, (a,b)-> a[1] - b[1]); // sort by end points
        int arrows = 1;
        int preEndPoint = points[0][1];

        for (int i = 1; i < n; i++) {
            // within range
            if (points[i][0] <= preEndPoint && preEndPoint <= points[i][1]) {
                continue;
            } else {
                // use new arrow
                arrows++;
                preEndPoint = points[i][1];
            }
        }

        return arrows;

    }
}