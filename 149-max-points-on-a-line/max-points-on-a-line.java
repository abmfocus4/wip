// brute-force - O(n3)
// https://www.youtube.com/watch?v=AzER0wuL0QY&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=11&ab_channel=codestorywithMIK
class Solution {
    public int maxPoints(int[][] points) {
        int totalPoints = 0;
        int n = points.length;
        if (n <= 1) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = 2;
                // x2 - x1
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        int dx_ = points[k][0] - points[i][0]; // x3-x1
                        int dy_ = points[k][1] - points[i][1];
                        
                        // dy/dx = dy_/dx_ = dy * dx
                        if (dy * dx_ == dy_ * dx) {
                            count++;
                        }
                    }
                }
                totalPoints = Math.max(totalPoints, count);
            }
            
        }

        return totalPoints;
    }
}